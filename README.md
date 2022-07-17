# geek11week
一.（必做）基于 Redis 封装分布式数据操作：

在 Java 中实现一个简单的分布式锁；在 Java 中实现一个分布式计数器，模拟减库存。

  （1）[模拟减库的Controller](https://github.com/hafizgoo/geek11week/blob/main/src/main/java/com/hafizgoo/order/conntroller/RegisterConntroller.java)
   
  （2）[模拟减库的Service](https://github.com/hafizgoo/geek11week/blob/main/src/main/java/com/hafizgoo/order/service/impl/RegisterServiceImpl.java)
   
  （3）[分布式锁]( https://github.com/hafizgoo/geek11week/blob/main/src/main/java/com/hafizgoo/order/redis/RedisLock.java)
  
  （4）[具体执行增减库存的方法](https://github.com/hafizgoo/geek11week/blob/main/src/main/java/com/hafizgoo/order/task/ThreadTask.java)
  

二.（必做）基于 Redis 的 PubSub 实现订单异步处理

（1）[订单处理]( https://github.com/hafizgoo/geek11week/blob/main/src/main/java/com/hafizgoo/order/redis/SubscribeOrder.java)

（2）[订单发布]( https://github.com/hafizgoo/geek11week/blob/main/src/main/java/com/hafizgoo/order/redis/PublishOrder.java)

（3）[Main方法]( https://github.com/hafizgoo/geek11week/blob/main/src/main/java/com/hafizgoo/order/redis/Main.java)
