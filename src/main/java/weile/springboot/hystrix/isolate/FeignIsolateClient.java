package weile.springboot.hystrix.isolate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Auth weile
 * @Time 2019-05-11 16:48
 * @Description feign客户端
 **/
@FeignClient(url ="http://localhost:8080",name = "mock" ,fallback = FeignIsolateClientFallBack.class)
public interface FeignIsolateClient {

	@RequestMapping(value = "/mock", method = RequestMethod.GET)
	@ResponseBody
	String callwithCustomRT(@RequestParam(name = "isok",required = false,defaultValue = "1")  boolean isMockOk,@RequestParam(name = "timeout",required = false,defaultValue = "500") Long timeout );

}
