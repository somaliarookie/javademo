package weile.springboot.elasticsearch;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class ElasticsearchController {


    @Autowired
    private OrderInfoRepository repository;



    @RequestMapping(value = "/es/findall")
    public Iterable<OrderInfo> findall() {
        return repository.findAll();
    }




}
