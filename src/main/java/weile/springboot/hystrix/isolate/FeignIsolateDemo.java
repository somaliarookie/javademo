package weile.springboot.hystrix.isolate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auth weile
 * @Time 2019-05-11 17:25
 * @Description feign 客户端熔断实例
 **/

@RestController
public class FeignIsolateDemo {


	@Autowired
	private  FeignIsolateClient feignIsolateClient;

	@RequestMapping("/isolate")
	String mock(@RequestParam(name = "isok",required = false,defaultValue = "1")  boolean isMockOk,@RequestParam(name = "timeout",required = false,defaultValue = "0") Long timeout ,@RequestParam(name = "e",required = false,defaultValue = "0") Long exception) {


		String callwithCustomRT = feignIsolateClient.callwithCustomRT(isMockOk, timeout,exception);


		return callwithCustomRT;

	}


}
