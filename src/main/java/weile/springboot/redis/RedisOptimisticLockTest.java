package weile.springboot.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.Transaction;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;


@Component

/**
 * redis乐观锁实例： 库存问题
 * 库存问题模型：同一时间内存在多个针对同一件商品的库存修改
 *
 */
public class RedisOptimisticLockTest {


    private static final Logger logger = LoggerFactory.getLogger(RedisOptimisticLockTest.class);
    private JedisHolder jedisHolder;
    private String key = "stock";


    /**
     * workers为同一时间内库存修改的数量，每一个修改对应一个线程
     * @param workers
     */
    public void execute(int workers) {


        init();//初始化

        for (int i=0;i<workers;i++)
        {
            //启动线程模拟同一时间的多个修改
           new Thread(()->{
               jedisHolder = new JedisHolder();


               ShardedJedis shardJedis = jedisHolder.getPool().getResource();
               try {
                   int k = 3;
                   while (k-- > 0) {
                       Object domain;
                       //获取连接
                       Jedis jedis = shardJedis.getShard(key);
                       //开始监控key的变化
                       jedis.watch(key);
                       //执行业务操作
                       String stockStr = jedis.get(key);
                       int stock=Integer.valueOf(stockStr)-1;


                       //开启提交事务
                       Transaction t = jedis.multi();

                       //具体提交动作
                       t.set(key, String.valueOf(String.valueOf(stock)));
                       //提交
                       List<Object> list = t.exec();
                       if (list != null ) {//提交成功，在监控key开始到提交之前，key对应的value没有发生变化
                           logger.info("cut stock success stock:{}",stock);

                       } else {//提交失败，在监控key开始到提交之前，key对应的value没有产生变化
                           logger.info("cut stock failed stock:{}",stockStr);
                       }
                   }
               } catch (Exception e) {
                   throw new RuntimeException("serialize or deserialize failed : " + key, e);
               } finally {
                   if (shardJedis != null)
                       shardJedis.close();
               }
                   }
           ).start();
        }

    }


    /**
     * 初始化
     */
    private void init() {
        jedisHolder = new JedisHolder();
        ShardedJedis shardJedis = jedisHolder.getPool().getResource();
        Jedis jedis = shardJedis.getShard(key);
        jedis.set(key,"100");

    }




}
