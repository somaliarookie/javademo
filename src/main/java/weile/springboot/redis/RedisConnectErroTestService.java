//package weile.springboot.redis;
//
//import com.juanpi.sdk.api.redis.RedisService;
//import org.apache.commons.lang3.math.NumberUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.stereotype.Service;
//
///**
// * @Auth weile
// * @Time 2018/12/21 10:41
// * @Description TODO
// **/
//
//@Service("redisTestService")
//public class RedisConnectErroTestService
//{
//    @Autowired
//    @Qualifier("redisService")
//    private RedisService redisService;
//
//    public void connectTest() {
//
//
//        for (int i = 0; i < 1000; i++) {
//            redisService.set("test","value",10000);
//            String a = redisService.get("a");
//            System.out.println(a);
//        }
//
//    }
//
//
//
//}
