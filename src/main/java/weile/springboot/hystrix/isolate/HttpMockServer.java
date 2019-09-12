package weile.springboot.hystrix.isolate;

import org.aspectj.apache.bcel.classfile.Module;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auth weile
 * @Time 2019-05-11 16:48
 * @Description TODO
 **/
@RestController
public class HttpMockServer {

    @RequestMapping("/mock")
    String hello(@RequestParam(name = "isok",required = false,defaultValue = "1")  boolean isMockOk,@RequestParam(name = "timeout",required = false,defaultValue = "500") Long timeout ) {


        if (isMockOk) {
            return "mock server: normal ";

        }else {
            try {
                Thread.sleep(timeout);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "mock server: abnormal timeout:"+timeout+"milliseconds";
        }

    }



}

