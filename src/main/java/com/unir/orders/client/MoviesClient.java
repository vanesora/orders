package com.unir.orders.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.unir.orders.model.pojo.ElasticMovie;


@FeignClient(name = "ms-movies", url = "${getorders.api.url}")
public interface MoviesClient {


	@GetMapping("/movies/{movieId}")
	public @ResponseBody ResponseEntity<ElasticMovie> getMovieById(@PathVariable String movieId);

}
