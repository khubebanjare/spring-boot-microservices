package com.khube.main.product.service.impl;

import com.khube.main.product.entity.Product;
import com.khube.main.product.exception.ProductAlreadyPresent;
import com.khube.main.product.exception.ProductIsNotPresent;
import com.khube.main.product.exception.ProductNotFoundException;
import com.khube.main.product.helper.ProductHelper;
import com.khube.main.product.repository.ProductRepository;
import com.khube.main.product.request.ProductRequest;
import com.khube.main.product.response.ProductResponse;
import com.khube.main.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductRequest productRequest;
    @Autowired
    private ProductResponse productResponse;

    @Override
    public ProductRequest saveProduct(Product product) {
       if(productRepository.existsById(product.getProductId()))
    	   throw new ProductAlreadyPresent("Product Already prseent...");
        
       Product newProduct = productRepository.save(product);
       productRequest = ProductHelper.setProductDetailsForRequest(newProduct);
       return productRequest;
    }

    @Override
    public List<ProductResponse> getProducts() {
        List<Product> products = productRepository.findAll();
        List<ProductResponse> productResponses = new ArrayList<ProductResponse>();
        if(!products.isEmpty()){
            products.forEach(product -> {
                productResponse = ProductHelper.setProductDetailsForResponse(product);
                productResponses.add(productResponse);
            });
        }
        else
            throw new ProductNotFoundException("Product Not Found");
        return productResponses;
    }

    @Override
    public Optional<ProductResponse> getProductById(Integer productId) {
        Product existProduct = productRepository.findById(productId)
                                .orElseThrow(
                                () -> new ProductIsNotPresent("Product is not present for given Product ID!!! : " + productId));
        productResponse = ProductHelper.setProductDetailsForResponse(existProduct);
        Optional<ProductResponse> productResponseOptional = Optional.of(productResponse);
        if(productResponseOptional.isPresent())
            return productResponseOptional;
        else
            throw new ProductNotFoundException("Product Not Found");
    }
}
