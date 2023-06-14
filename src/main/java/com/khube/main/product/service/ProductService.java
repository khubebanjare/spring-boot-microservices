package com.khube.main.product.service;

import com.khube.main.product.entity.Product;
import com.khube.main.product.request.ProductRequest;
import com.khube.main.product.response.ProductResponse;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    public ProductRequest saveProduct(Product product);

    public List<ProductResponse> getProducts();

    public Optional<ProductResponse> getProductById(Integer productId);
    
    public ProductRequest updateProduct(Integer productId, Product product);
    
    public String deleteByProductId(Integer productId);
    
    public String deleteAllProducts();
}
