package weile.springboot.hystrix.isolate;

import org.springframework.stereotype.Component;

/**
 * @Auth weile
 * @Time 2019-05-18 21:56
 * @Description TODO
 **/

@Component
public class FeignIsolateClientFallBack implements FeignIsolateClient {
	@Override
	public String callwithCustomRT(boolean isMockOk, Long timeout) {
		return "callwithCustomRT call back";
	}
}
