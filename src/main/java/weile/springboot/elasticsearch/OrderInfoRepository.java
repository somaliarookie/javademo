package weile.springboot.elasticsearch;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface OrderInfoRepository   extends ElasticsearchRepository<OrderInfo, String> {


}
