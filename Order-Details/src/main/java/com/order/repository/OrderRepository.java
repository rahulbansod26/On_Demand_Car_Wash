package com.order.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.order.model.Order;

@Repository
public interface OrderRepository extends MongoRepository<Order,Integer> {
	List<Order> findByCustomerName(String customerName);

	Optional<Order> findById(int orderId);
	
}
