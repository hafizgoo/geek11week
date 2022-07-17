package com.hafizgoo.order.service;

import redis.clients.jedis.JedisPool;

/**
 * @Auther: hafizgoo
 * @Date: DATE−2022/7/12 - MONTH−07 - DAY−12 - TIME−7:13
 * @Description: com.hafizgoo.order.service
 * @version: 1.0
 */


public interface RegisterService {
    //减库存
    public String cutDown();
}
