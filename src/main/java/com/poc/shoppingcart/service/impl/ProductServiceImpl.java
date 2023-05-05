package com.poc.shoppingcart.service.impl;

import java.util.List;

import com.poc.shoppingcart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poc.shoppingcart.entity.Product;
import com.poc.shoppingcart.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	public List<Product> getAllProducts() {
		return this.productRepository.findAll();
	}

	public List<Product> saveProducts(List<Product> products) {
		return productRepository.saveAll(products);
	}
	
	public List<Product> getProductsByCategory(String category){
		System.out.println(productRepository.findByCategory(category));
		return productRepository.findByCategory(category);
	}
}
