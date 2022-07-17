package com.hafizgoo.order.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.time.Duration;
import java.util.Collections;

/**
 * @Auther: hafizgoo
 * @Date: DATE−2022/7/12 - MONTH−07 - DAY−12 - TIME−7:24
 * @Description: com.hafizgoo.order.redis
 * @version: 1.0
 */


@Component
public class RedisLock {


    private static final JedisPool pool=new JedisPool();

    private static final String SET_IF_NOT_EXIST = "NX";
    private static final String SET_WITH_EXPIRE_TIME = "PX";
    private static final int EXPIRE_TIME = 500;
    private static final Long RELEASE_SUCCESS = 1L;

    public static Jedis getJedis(){
        return pool.getResource();
    }

    public static void close(Jedis jedis){
        jedis.close();
    }



    //加锁方法
    //加锁之后返回锁的持有者(锁的value使用唯一时间戳标志每个客户端,保证只有锁的持有者才可以释放锁)
    public static String lock(Jedis jedis, String key,Long waitEnd,String requestId) {
        try {
            // 1秒内数次加锁如果失败,则不断请求重新获取锁,超过1秒还没能加锁,就加锁失败(为了每个线程拥有公平的机会获取锁)
            while (System.currentTimeMillis() < waitEnd) {
                String result = jedis.set(key, requestId, SET_IF_NOT_EXIST, SET_WITH_EXPIRE_TIME, EXPIRE_TIME);
                if ("OK".equals(result)) {
                    return requestId;
                }
            }
        } catch (Exception ex) {
           ex.printStackTrace();
        }
        return null;
    }


    /**
     * 释放分布式锁
     * @param jedis Redis客户端
     * @param lockKey 锁
     * @param requestId 请求标识
     * @return 是否释放成功
     */
    public static boolean unLock(Jedis jedis, String lockKey, String requestId) {

        String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
        Object result = jedis.eval(script, Collections.singletonList(lockKey), Collections.singletonList(requestId));
        return RELEASE_SUCCESS.equals(result);
    }



}
