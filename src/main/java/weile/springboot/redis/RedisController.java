package weile.springboot.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class RedisController {

    @Autowired
    private  RedisOptimisticLockTest  test;

    @RequestMapping(value = "/redis/optest")
    public boolean testOptimistic() {

        test.execute(10);

        return true;
    }


//    @Autowired
//    private RedisService redisService;
//
//    @RequestMapping(value = "/redis/set")
//    public boolean insert() {
//        return redisService.set("name", "cc");
//    }
//
//    @RequestMapping(value = "/redis/get")
//    public String get() {
//        return redisService.get("name").toString();
//    }

}