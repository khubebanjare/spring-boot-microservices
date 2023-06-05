package com.khube.main.product.controller;

import com.khube.main.product.entity.Product;
import com.khube.main.product.request.ProductRequest;
import com.khube.main.product.response.ProductResponse;
import com.khube.main.product.service.ProductService;
import com.khube.main.product.util.Mapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product/api")
public class ProductController {

    @Autowired
    private ProductService productService;
    private static final Logger LOGGER = LogManager.getLogger(ProductController.class);

    @PostMapping(value = "/products")
    public ResponseEntity<ProductRequest> saveProduct(@RequestBody Product product){
        LOGGER.info("ProductServiceImpl:saveProduct request from client {} " + Mapper.mapToJsonString(product));
        ProductRequest productRequest = productService.saveProduct(product);
        LOGGER.info("ProductServiceImpl:saveProduct response from service {} " + Mapper.mapToJsonString(productRequest));
        return new ResponseEntity<ProductRequest>(productRequest, HttpStatus.CREATED);
    }

    @GetMapping(value = "/products")
    public ResponseEntity<List<ProductResponse>> getProducts(){
        List<ProductResponse> productResponses = productService.getProducts();
        LOGGER.info("ProductServiceImpl:getProducts response from service {} " + productResponses);
        return new ResponseEntity<>(productResponses, HttpStatus.OK);
    }

    @GetMapping(value = "/products/{productId}")
    public ResponseEntity<Optional<ProductResponse>> getProductById(@PathVariable Integer productId){
        LOGGER.info("ProductServiceImpl:getProducts request from client {} " + productId);
        Optional<ProductResponse> optionalProduct = productService.getProductById(productId);
        LOGGER.info("ProductServiceImpl:getProducts response from service {} " + optionalProduct);
        return new ResponseEntity<Optional<ProductResponse>>(optionalProduct, HttpStatus.OK);
    }
}
