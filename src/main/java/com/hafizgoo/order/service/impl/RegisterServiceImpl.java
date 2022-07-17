package com.hafizgoo.order.service.impl;

import com.hafizgoo.order.service.RegisterService;
import com.hafizgoo.order.task.ThreadTask;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisPool;

import java.util.concurrent.*;

/**
 * @Auther: hafizgoo
 * @Date: DATE−2022/7/12 - MONTH−07 - DAY−12 - TIME−7:14
 * @Description: com.hafizgoo.order.service.impl
 * @version: 1.0
 */

@Service
public class RegisterServiceImpl implements RegisterService {
    @Override
    public String cutDown() {
        //启动一个线程池模拟多人抢购
        ExecutorService pool1 = new ThreadPoolExecutor(4, 10, 1000, TimeUnit.MILLISECONDS, new PriorityBlockingQueue<Runnable>(), Executors.defaultThreadFactory());
        for(int i=0;i<50;i++) {//模拟100个人同时抢购5件商品
            String userCode = 10*(i+1)+"";
            pool1.execute(new ThreadTask("101",userCode,1L));
        }
        return null;
    }
}
