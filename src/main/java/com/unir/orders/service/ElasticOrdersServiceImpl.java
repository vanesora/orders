package com.unir.orders.service;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.unir.orders.data.ElasticsearchRepository;
import com.unir.orders.model.pojo.ElasticOrders;
import com.unir.orders.model.request.OrderRequest;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ElasticOrdersServiceImpl implements ElasticOrdersService {

	private final ElasticsearchRepository repository;

	

	@Override
	public ElasticOrders createOrder(OrderRequest request) {

		if (request != null && request.getMovieId()!=null) {
		    	ElasticOrders orders =
		    		ElasticOrders.builder()
		              .movieId(request.getMovieId())
		              .fecha(new Date())
		              .build();
			return repository.saveOrder(orders);
		} else {
			return null;
		}
	}
	

}
