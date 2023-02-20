package com.unir.orders.model.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "movies")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Movie {
	@Builder.Default private long created = System.currentTimeMillis();
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "name", unique = true)
	private String name;
	
	@Column(name = "director")
	private String director;
	
	@Column(name = "score")
	private Integer score;
	
	@Column(name = "duration")
	private Integer duration;
	
	@Column(name = "category")
	private String category;
	
	@Column(name = "img")
	private String img;
	
	@Column(name = "synopsis")
	private String synopsis;
	
	@Column(name = "trailer")
	private String trailer;

}

