package com.unir.orders.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unir.orders.model.pojo.Orders;

public interface OrdersRepository extends JpaRepository<Orders, Long> {
	
}
