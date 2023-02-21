package com.unir.orders.model.pojo;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Document(indexName = "orders", createIndex = true)
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ElasticOrders {

	@Id
	private Long id;
	
	@Field(type = FieldType.Keyword, name = "movieId")
	private Long movieId;

	@Field(type = FieldType.Keyword, name = "fecha")
	private Date fecha;

}
