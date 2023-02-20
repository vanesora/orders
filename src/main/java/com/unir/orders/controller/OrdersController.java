package com.unir.orders.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.unir.orders.client.MoviesClient;
import com.unir.orders.model.pojo.Movie;
import com.unir.orders.model.pojo.Orders;
import com.unir.orders.model.request.OrderRequest;
import com.unir.orders.service.OrdersService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class OrdersController {

	private final MoviesClient service;

	@Autowired
	private OrdersService ordersService;

	@PostMapping("/save")
	public ResponseEntity<Orders> createOrder(@RequestBody OrderRequest request) {
		if (request != null && request.getMovieId() != null) {
			ResponseEntity<Movie> movie = service.getMovie(request.getMovieId().toString());
			if (movie.getBody() != null && movie.getBody().getId() != null) {
				Orders result = ordersService.createOrder(request);
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
	public ResponseEntity<Movie> getMovie(@PathVariable("movieId") String movieId) {

		ResponseEntity<Movie> movie = service.getMovie(movieId);

		if (movie.getBody() != null && movie.getBody().getId() != null) {
			return ResponseEntity.ok(movie.getBody());
		} else {
			return ResponseEntity.notFound().build();
		}

	}
}
