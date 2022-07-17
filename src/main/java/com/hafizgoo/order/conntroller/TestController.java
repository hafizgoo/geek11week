package com.hafizgoo.order.conntroller;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Auther: hafizgoo
 * @Date: DATE−2022/7/17 - MONTH−07 - DAY−17 - TIME−7:41
 * @Description: com.hafizgoo.order.conntroller
 * @version: 1.0
 */


@RestController
public class TestController {

    @Resource
    StringRedisTemplate stringRedisTemplate;


    @GetMapping("cat")
    public void sendCatMessage() {
        stringRedisTemplate.convertAndSend("cat", "猫");
    }

    @GetMapping("fish")
    public void sendFishMessage() {
        stringRedisTemplate.convertAndSend("fish", "鱼");
    }


}