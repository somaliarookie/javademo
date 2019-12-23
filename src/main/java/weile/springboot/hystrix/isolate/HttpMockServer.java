package weile.springboot.hystrix.isolate;

import org.aspectj.apache.bcel.classfile.Module;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

/**
 * @Auth weile
 * @Time 2019-05-11 16:48
 * @Description TODO
 **/
@RestController
public class HttpMockServer {

    @RequestMapping("/mock")
    String hello(@RequestParam(name = "isok",required = false,defaultValue = "1")  boolean isMockOk,@RequestParam(name = "timeout",required = false,defaultValue = "500") Long timeout,@RequestParam(name = "e",required = false,defaultValue = "0") Long exception ) throws Exception {


        long start = System.currentTimeMillis();
        if (!isMockOk && timeout>0) {

            try {
                Thread.sleep(timeout);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if (exception ==1) {

            throw new Exception("exception!");
        }


        return "server: time cost :"+(System.currentTimeMillis()-start);

    }



}

