package weile.springboot.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class RedisController {


//    @Autowired
//    private   RedisConnectErroTestService redisConnectErroTestService;
//
//    @RequestMapping(value = "/redis/test")
//    public boolean connectionTest() {
//
//        redisConnectErroTestService.connectTest();
//
//        return true;
//    }
//
//    @Autowired
//    private  RedisOptimisticLockTest  test;
//
//    @RequestMapping(value = "/redis/optest")
//    public boolean connectionTest() {
//
//        test.execute(100000);
//
//        return true;
//    }


    @Autowired
    private RedisService redisService;

    @RequestMapping(value = "/redis/set")
    public boolean insert() {
        return redisService.set("name", "cc");
    }

    @RequestMapping(value = "/redis/get")
    public String get() {
        return redisService.get("name").toString();
    }

    @RequestMapping(value = "/redis/idempotent")
    public Boolean idempotent(@RequestParam(name = "name",defaultValue = "1233")String name ) {

        Assert.notNull(name,"name not null");
        return redisService.idempotent("name",1000L);
    }


}
