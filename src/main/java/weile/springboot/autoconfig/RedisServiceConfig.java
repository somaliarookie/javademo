//package weile.springboot.autoconfig;
//
//import com.juanpi.redis.spring.boot.autoconfigure.RedisBuilder;
//import com.juanpi.sdk.api.redis.*;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//
//@Configuration
//public class RedisServiceConfig {
//
//    private static final Logger LOGGER = LoggerFactory.getLogger(RedisServiceConfig.class);
//
//    @Bean(name="defaultRedis")
//    @ConfigurationProperties(prefix = "redis.test")
//    public RedisDataSource redisDataSource(){
//        return RedisBuilder.create().build();
//    }
//
//    @Primary
//    @Bean(name="redisService")
//    public RedisService redisService(){
//        RedisDataSource redisDataSource = redisDataSource();
//        LOGGER.info("default redisService value = > {}", redisDataSource);
//        return RedisServiceFactory.getRedisService(redisDataSource);
//    }
//
//
//
//}
