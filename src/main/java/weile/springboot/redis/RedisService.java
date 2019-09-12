package weile.springboot.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.time.Duration;


@Component
public class RedisService {


    @Autowired
    private RedisTemplate redisTemplate;




    /**
     * 写入缓存
     * @param key
     * @param value
     * @return
     */
    public boolean set(final String key, Object value) {
        boolean result = false;
        try {
            ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
            operations.set(key, value);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    /**
     * 幂等性
     * @param factor
     * @return
     */
    public Boolean idempotent( String factor,Long expireTime) {
        Boolean isOk = false;
        ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
        isOk= operations.setIfAbsent(factor,"1", Duration.ofMillis(expireTime));
        return isOk;

    }
    /**
     * 读取缓存
     * @param key
     * @return
     */
    public Object get(final String key) {
        Object result = null;
        ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
        result = operations.get(key);
        return result;

    }





    }
