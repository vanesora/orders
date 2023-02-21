package com.unir.orders.data;

import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.stereotype.Component;

import com.unir.orders.model.pojo.ElasticOrders;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ElasticsearchRepository {


  private final ElasticOrdersRepository orderRepository;
  //private final ElasticsearchOperations elasticClient;

  public ElasticOrders saveOrder(ElasticOrders order) {
    return orderRepository.save(order);
  }
  


}
