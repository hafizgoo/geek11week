package com.hafizgoo.order.redis;

import redis.clients.jedis.JedisPool;

/**
 * @Auther: hafizgoo
 * @Date: DATE−2022/7/17 - MONTH−07 - DAY−17 - TIME−6:31
 * @Description: com.hafizgoo.order.redis
 * @version: 1.0
 */


public class Main {

    public static void main(String[] args) {
        JedisPool jedisPool = new JedisPool();
        String channelName = "ORDER";

        SubscribeOrder subscribeOrder = new SubscribeOrder(jedisPool, channelName);
        PublishOrder publishOrder = new PublishOrder(jedisPool, channelName);
    }
}
