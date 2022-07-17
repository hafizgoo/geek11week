package com.hafizgoo.order.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPubSub;



public class SubscribeOrder {

    public SubscribeOrder(final JedisPool jedisPool, final String channelName) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("开始处理订单:");
                try(Jedis jedis = jedisPool.getResource()) {
                    jedis.subscribe(setupSubscriber(), channelName);
                }
            }
        }, "subscriberThread").start();
    }

    private JedisPubSub setupSubscriber() {
        return new JedisPubSub() {
            @Override
            public void onMessage(String channel, String message) {
                if (message.isEmpty()) {
                    System.out.println("订单处理结束");
                    System.exit(0);
                }
                System.out.printf("开始处理 %s :: %s\n", channel, message);
            }
        };
    }
}
