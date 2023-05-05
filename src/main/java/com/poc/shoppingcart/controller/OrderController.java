package com.poc.shoppingcart.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poc.shoppingcart.entity.Order;
import com.poc.shoppingcart.service.OrderService;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@PostMapping(value = "/orders/create")
	public Order createOrder(@RequestBody Order order) {
		return orderService.crateOrder(order);
	}

	@PostMapping(value ="/orders")
	public List<Order> createOrders(@RequestBody List<Order> orders){
		return orderService.createOrders(orders);
	}
	@GetMapping(value = "/orders")
	public List<Order> getAllOrders(){
		return orderService.getAllOrders();
	}

	@GetMapping(value = "/orders/{orderId}")
	public Optional<Order> getOrderById(@PathVariable Long orderId) {
		return orderService.findByOrderId(orderId);
	}

}
