package weile.springboot.basic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;
import weile.Config;
import weile.springboot.basic.RedisService;
import weile.springboot.basic.controller.dto.PostParam;

@RestController
@EnableAutoConfiguration
public class BasicController {


    @Autowired
    private Config config;


    @Autowired
    private RedisService redisService;

    @RequestMapping(value = "/insert")
    public boolean insert() {
        return redisService.set("name", "cc");
    }

    @RequestMapping(value = "/get")
    public String get() {
        return redisService.get("name").toString();
    }

    @RequestMapping("/hello")
    String hello() {
        return "Hello World!" + config.getTestInfo() + config.getTestInfo1();
    }


    @PostMapping("/test/post")
    String testPost(@RequestBody PostParam param) {
        return "postTest success "+param;
    }
}