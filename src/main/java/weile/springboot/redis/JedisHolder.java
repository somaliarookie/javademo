//package weile.springboot.redis;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import redis.clients.jedis.JedisPoolConfig;
//import redis.clients.jedis.JedisShardInfo;
//import redis.clients.jedis.ShardedJedisPool;
//import weile.springboot.autoconfig.RedisPoolConfig;
//import weile.util.SpringContextUtil;
//
//import java.util.ArrayList;
//import java.util.List;
//public class JedisHolder {
//
//
//    public ShardedJedisPool getPool() {
//        return pool;
//    }
//
//    public void setPool(ShardedJedisPool pool) {
//        this.pool = pool;
//    }
//
//    private ShardedJedisPool pool;
//
//    public JedisHolder() {
//
//        RedisPoolConfig redisPoolConfig = SpringContextUtil.getBean(RedisPoolConfig.class);
//        String redisShardAddr =redisPoolConfig.getAddr();
//        if(redisShardAddr == null){
//            throw new RuntimeException("not found redis shard addr config.");
//        }
//        List<JedisShardInfo> shardADDRList = getJedisShardList(redisShardAddr);
//
//        init(shardADDRList);
//
//    }
//
//
//    private List<JedisShardInfo> getJedisShardList(String redisShardAddr){
//        List<JedisShardInfo> shardADDRList = new ArrayList<>();
//        for(String temp : redisShardAddr.split(",")){
//            String[] addr = temp.split(":");
//            String host = addr[0];
//            int port = Integer.parseInt(addr[1]);
//            shardADDRList.add(new JedisShardInfo(host,port));
//        }
//        return shardADDRList;
//    }
//
//    private static class Holder {
//        private static JedisHolder holder = new JedisHolder();
//    }
//
//    public static JedisHolder getInstance() {
//        return Holder.holder;
//    }
//
//    /**
//     *
//     * <pre>
//     * 		redis pool 初始化
//     * </pre>
//     *
//     * @param shardADDRList redis_address
//     */
//    public void init(List<JedisShardInfo> shardADDRList) {
//        if (pool == null) {
//            JedisPoolConfig config = new JedisPoolConfig();
//            // jedis的最大分配对象#
//            // 控制一个pool可分配多少个jedis实例，通过pool.getResource()来获取；
//            // 如果赋值为-1，则表示不限制；如果pool已经分配了maxActive个jedis实例，则此时pool的状态为exhausted(耗尽)。
//            config.setMaxTotal(100);
//            // #jedis最大保存idel状态对象数 #
//            // 控制一个pool最多有多少个状态为idle(空闲的)的jedis实例。
//            config.setMaxIdle(10);
//
//            // #jedis池没有对象返回时，最大等待时间 #
//            // 表示当borrow(引入)一个jedis实例时，最大的等待时间，如果超过等待时间，则直接抛出JedisConnectionException；
//            config.setMaxWaitMillis(1000 * 100);
//
//            // #jedis调用borrowObject方法时，是否进行有效检查#
//            // 在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的；
//            config.setTestOnBorrow(true);
//
//
//
//            // #jedis调用returnObject方法时，是否进行有效检查 #
//            // config.setTestOnReturn(true);
//
//            pool = new ShardedJedisPool(config, shardADDRList);
//        }
//    }
//
//}
