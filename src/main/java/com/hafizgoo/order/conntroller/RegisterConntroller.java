package com.hafizgoo.order.conntroller;

import com.hafizgoo.order.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import redis.clients.jedis.JedisPool;

/**
 * @Auther: hafizgoo
 * @Date: DATE−2022/7/12 - MONTH−07 - DAY−12 - TIME−6:29
 * @Description: com.hafizgoo.order
 * @version: 1.0 */

@RestController
public class RegisterConntroller {

    @Autowired
    private RegisterService registerService;



    @GetMapping("/redis/order")
    public void  order(){
        registerService.cutDown();
    }
}