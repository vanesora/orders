package com.unir.orders.service;

import com.unir.orders.model.pojo.ElasticOrders;
import com.unir.orders.model.request.OrderRequest;

public interface ElasticOrdersService {
  
	ElasticOrders createOrder(OrderRequest request);

}
