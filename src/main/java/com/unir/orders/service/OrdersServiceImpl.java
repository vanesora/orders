package com.unir.orders.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unir.orders.data.OrdersRepository;
import com.unir.orders.model.pojo.Orders;
import com.unir.orders.model.request.OrderRequest;

@Service
public class OrdersServiceImpl implements OrdersService {
	
	@Autowired
	private OrdersRepository repository;

	

	@Override
	public Orders createOrder(OrderRequest request) {

		if (request != null && request.getMovieId()!=null) {
			Orders orders = Orders.builder()
					.movieId(request.getMovieId())
					.fecha(new Date())
					.build();
			return repository.save(orders);
		} else {
			return null;
		}
	}
}
