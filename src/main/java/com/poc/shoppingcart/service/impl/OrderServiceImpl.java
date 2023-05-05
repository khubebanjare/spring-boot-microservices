package com.poc.shoppingcart.service.impl;

import java.util.List;
import java.util.Optional;

import com.poc.shoppingcart.entity.ShoppingCart;
import com.poc.shoppingcart.exception.OrderNotFoundException;
import com.poc.shoppingcart.exception.OrderReferenceAlreadyExistsException;
import com.poc.shoppingcart.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poc.shoppingcart.entity.Order;
import com.poc.shoppingcart.repository.OrderRepository;
import com.poc.shoppingcart.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private ShoppingCartService shoppingCartService;

	private ShoppingCart getOrder(Order order){
		System.out.println("order = " + order);
		List<ShoppingCart> carts = shoppingCartService.getAllShoppingProducts();
		carts.forEach(System.out::println);
		for (ShoppingCart cart : carts) {
			System.out.println("get total : " + cart.getQuantity());
			if(order.getShoppingCart().contains(cart.getShoppingCartId())) {
				order.getShoppingCart().listIterator().next().getAvailableQuantity();
				order.getShoppingCart().listIterator().next().getQuantity();
			}
			order.setSubTotal(cart.getPrice() * cart.getQuantity());
		}
		//throw new OrderNotFoundException("Order Not Found");
		return order.getShoppingCart().listIterator().next();
	}

	@Override
	public Order crateOrder(Order order) {
		ShoppingCart cart = getOrder(order);
		Order saveOrder =  orderRepository.save(order);
		return saveOrder;
	}

	@Override
	public List<Order> createOrders(List<Order> orders) {
		return orderRepository.saveAll(orders);
	}

	@Override
	public List<Order> getAllOrders(){
		return orderRepository.findAll();
	}

	@Override
	public Optional<Order> findByOrderId(Long orderId) {
		return orderRepository.findById(orderId);
	}

}
