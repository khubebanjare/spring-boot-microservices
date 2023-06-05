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
import com.khube.main.product.util.Mapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private static final Logger LOGGER = LogManager.getLogger(ProductServiceImpl.class);
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductRequest productRequest;
    @Autowired
    private ProductResponse productResponse;

    @Override
    public ProductRequest saveProduct(Product product) {
        LOGGER.info("ProductServiceImpl:saveProduct execution started...");
       if(productRepository.existsById(product.getProductId()))
    	   throw new ProductAlreadyPresent("Product Already present...");

        LOGGER.debug("ProductServiceImpl:saveProduct Request payload {} " + Mapper.mapToJsonString(product));
       Product newProduct = productRepository.save(product);
        LOGGER.debug("ProductServiceImpl:saveProduct response payload {} " + Mapper.mapToJsonString(product));
       productRequest = ProductHelper.setProductDetailsForRequest(newProduct);
        LOGGER.debug("ProductServiceImpl:saveProduct Response {} " + Mapper.mapToJsonString(product));
        LOGGER.info("ProductServiceImpl:saveProduct execution ended....");
       return productRequest;
    }

    @Override
    public List<ProductResponse> getProducts() {
        LOGGER.info("ProductServiceImpl:getProducts execution started....");
        List<Product> products = productRepository.findAll();
        LOGGER.info("ProductServiceImpl:getProducts getting all products {} " + products);
        List<ProductResponse> productResponses = new ArrayList<ProductResponse>();
        LOGGER.debug("ProductServiceImpl:getProducts Fetching all product one by one..");
        if(!products.isEmpty()){
            products.forEach(product -> {
                productResponse = ProductHelper.setProductDetailsForResponse(product);
                LOGGER.info("ProductServiceImpl:getProducts converting response type {} " + productResponse);
                LOGGER.info("ProductServiceImpl:getProducts ....");
                productResponses.add(productResponse);
            });
        }
        else
            throw new ProductNotFoundException("Product Not Found");
        LOGGER.info("ProductServiceImpl:getProducts execution ended....");
        return productResponses;
    }

    // hello new line added on this project
    @Override
    public Optional<ProductResponse> getProductById(Integer productId) {
        LOGGER.info("ProductServiceImpl:getProductById execution started....");
        Product existProduct = productRepository.findById(productId)
                                .orElseThrow(
                                () -> new ProductIsNotPresent("Product is not present for given Product ID!!! : " + productId));

        productResponse = ProductHelper.setProductDetailsForResponse(existProduct);
        LOGGER.info("ProductServiceImpl:getProductById converting response type {} " + productResponse);
        Optional<ProductResponse> productResponseOptional = Optional.of(productResponse);
        LOGGER.info("ProductServiceImpl:getProductById adding in optional class {} " + productResponse);
        if(productResponseOptional.isPresent())
            return productResponseOptional;
        else
            throw new ProductNotFoundException("Product Not Found");
    }
}
