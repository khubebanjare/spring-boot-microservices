package com.poc.shoppingcart.service;

import com.poc.shoppingcart.entity.Product;

import java.util.List;

public interface ProductService {

    public List<Product> getAllProducts();

    public List<Product> saveProducts(List<Product> products);

    public List<Product> getProductsByCategory(String category);
}
