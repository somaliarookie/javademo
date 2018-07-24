package weile.springboot.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class RedisController {





    @Autowired
    private RedisService redisService;

    @RequestMapping(value = "/redis/insert")
    public boolean insert() {
        return redisService.set("name", "cc");
    }

    @RequestMapping(value = "/redis/get")
    public String get() {
        return redisService.get("name").toString();
    }

}