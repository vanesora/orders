package com.unir.orders.data;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.unir.orders.model.pojo.ElasticOrders;

public interface ElasticOrdersRepository extends ElasticsearchRepository<ElasticOrders, Long> {

}
