//package weile.springboot.elasticsearch;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Random;
//
//@RestController
//@EnableAutoConfiguration
//public class ElasticsearchController {
//
//
//    @Autowired
//    private OrderInfoRepository repository;
//
//
//
//    @RequestMapping(value = "/es/findall")
//    public Iterable<OrderInfo> findall() {
//        return repository.findAll();
//    }
//
//
//    @RequestMapping(value = "/es/add")
//    public void randomAdd() {
//
//        OrderInfo orderInfo=new OrderInfo();
//        orderInfo.setOrderno(String.valueOf(Math.random()));
//        orderInfo.setPaystatus(0);
//        orderInfo.setStatus(0);
//
//        repository.save(orderInfo);
//    }
//
//
//
//
//}
