package weile.springboot.autoconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import weile.springboot.basic.PostParam;
import weile.springboot.redis.RedisService;

@RestController
@EnableAutoConfiguration
public class AutoConfigController {


    @Autowired
    private Config config;


    @RequestMapping("/config")
    String hello() {
        return "config info:" + config.getTestInfo() + config.getTestInfo1();
    }


}