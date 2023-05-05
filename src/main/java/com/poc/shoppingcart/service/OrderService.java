package com.poc.shoppingcart.service;

import java.util.List;
import java.util.Optional;

import com.poc.shoppingcart.entity.Order;

public interface OrderService {
	
	public Order crateOrder(Order order);

	public List<Order> createOrders(List<Order> orders);
	public List<Order> getAllOrders();
	
	public Optional<Order> findByOrderId(Long orderId);
	
}
