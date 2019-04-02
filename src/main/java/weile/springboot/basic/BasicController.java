//package weile.springboot.basic;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@EnableAutoConfiguration
//public class BasicController {
//
//
//
//    @RequestMapping("/")
//    public String home() {
//        return "Hello world";
//    }
//
//    @RequestMapping("/get")
//    String hello() {
//        return "Hello World! this is get request";
//    }
//
//
//    @PostMapping("/post")
//    String testPost(@RequestBody PostParam param) {
//        return "postTest success "+param;
//    }
//}
