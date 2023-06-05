package com.khube.main.product.controller;

import com.khube.main.product.entity.Product;
import com.khube.main.product.request.ProductRequest;
import com.khube.main.product.response.ProductResponse;
import com.khube.main.product.service.ProductService;
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

    @PostMapping(value = "/products")
    public ResponseEntity<ProductRequest> saveProduct(@RequestBody Product product){
        System.out.println(product);
        ProductRequest productRequest = productService.saveProduct(product);
        return new ResponseEntity<ProductRequest>(productRequest, HttpStatus.CREATED);
    }

    @GetMapping(value = "/products")
    public ResponseEntity<List<ProductResponse>> getProducts(){
        List<ProductResponse> productResponses = productService.getProducts();
        return new ResponseEntity<>(productResponses, HttpStatus.OK);
    }

    @GetMapping(value = "/products/{productId}")
    public ResponseEntity<Optional<ProductResponse>> getProductById(@PathVariable Integer productId){
        Optional<ProductResponse> optionalProduct = productService.getProductById(productId);
        return new ResponseEntity<Optional<ProductResponse>>(optionalProduct, HttpStatus.OK);
    }
}
