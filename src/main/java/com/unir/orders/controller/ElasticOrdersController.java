package com.unir.orders.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.unir.orders.client.MoviesClient;
import com.unir.orders.model.pojo.ElasticMovie;
import com.unir.orders.model.pojo.ElasticOrders;
import com.unir.orders.model.pojo.Movie;
import com.unir.orders.model.request.OrderRequest;
import com.unir.orders.service.ElasticOrdersService;

import lombok.RequiredArgsConstructor;

@CrossOrigin(origins= {"*"}, maxAge = 16000, allowCredentials = "false" )
@RestController
@RequiredArgsConstructor
public class ElasticOrdersController {
  
  private final ElasticOrdersService ordersService;
  private final MoviesClient service;
  
	@PostMapping("/elastic/save")
	public ResponseEntity<ElasticOrders> createOrder(@RequestBody OrderRequest request) {
		if (request != null && request.getMovieId() != null) {
			ResponseEntity<ElasticMovie> movie = service.getMovieById(request.getMovieId().toString());
			if (movie.getBody() != null && movie.getBody().getId() != null) {
				ElasticOrders result = ordersService.createOrder(request);
				if (result != null) {
					return ResponseEntity.ok(result);
				} else {
					return ResponseEntity.badRequest().build();
				}
			} else {
				return ResponseEntity.notFound().build();
			}
		} else {
			return ResponseEntity.notFound().build();
		}

	}

	@GetMapping("/movies/{movieId}")
	public ResponseEntity<ElasticMovie> getMovie(@PathVariable("movieId") String movieId) {

		ResponseEntity<ElasticMovie> movie = service.getMovieById(movieId);

		if (movie.getBody() != null && movie.getBody().getId() != null) {
			return ResponseEntity.ok(movie.getBody());
		} else {
			return ResponseEntity.notFound().build();
		}

	}
  
  //////////////////////////////////////////
  
 


}
