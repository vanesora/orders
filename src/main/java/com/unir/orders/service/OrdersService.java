package com.unir.orders.service;

import com.unir.orders.model.pojo.Orders;
import com.unir.orders.model.request.OrderRequest;

public interface OrdersService {

	Orders createOrder(OrderRequest request);

}
