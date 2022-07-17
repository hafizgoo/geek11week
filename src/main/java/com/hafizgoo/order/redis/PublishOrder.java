package com.hafizgoo.order.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.Random;



public class PublishOrder {

    public PublishOrder(JedisPool jedisPool, String channelName) {
        System.out.println("开始发布订单:");
        try (Jedis jedis = jedisPool.getResource()) {
            int sleepTime = 0;
            for (int i = 0; i < 10; i++) {
                sleepTime = new Random().nextInt(10) + 1;

                try {
                    Thread.sleep(sleepTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                jedis.publish(channelName, "订单 " + i);
            }
            jedis.publish(channelName, "");
        }
    }
}
