package weile.springboot.basic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;
import weile.springboot.autoconfig.RedisPoolConfig;

@RestController
@EnableAutoConfiguration
public class BasicController {


    @Autowired
    RedisPoolConfig redisPoolConfig;

    @RequestMapping("/")
    public String home() {
        return "Hello world"+redisPoolConfig.getAddr();
    }

    @RequestMapping("/get")
    String hello() {
        return "Hello World! this is get request";
    }


    @PostMapping("/post")
    String testPost(@RequestBody PostParam param) {
        return "postTest success "+param;
    }
}