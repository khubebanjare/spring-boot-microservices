package com.khube.main.product.controller;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.khube.main.product.constant.SwaggerConfigValue;
import com.khube.main.product.entity.Product;
import com.khube.main.product.request.ProductRequest;
import com.khube.main.product.response.ProductResponse;
import com.khube.main.product.service.ProductService;
import com.khube.main.product.util.Mapper;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/product/api")
@Api(tags = {"Product Controller"})
@ApiResponses( value = {
        @ApiResponse(message = SwaggerConfigValue.OK, code = 200),
        @ApiResponse(message = SwaggerConfigValue.CREATED, code = 201),
        @ApiResponse(message = SwaggerConfigValue.FORBIDDEN, code = 404),
        @ApiResponse(message = SwaggerConfigValue.NOTFOUND, code = 400),
        @ApiResponse(message = SwaggerConfigValue.UNAUTHORIZED, code = 401),
        @ApiResponse(message = SwaggerConfigValue.INTERNALSERVERERROR, code = 500)
})
public class ProductController {

    @Autowired
    private ProductService productService;
    private static final Logger LOGGER = LogManager.getLogger(ProductController.class);

    @ApiOperation(value = SwaggerConfigValue.VALUE1, response = ProductRequest.class)
    @PostMapping(value = "/products")
    public ResponseEntity<ProductRequest> saveProduct(@RequestBody Product product){
        LOGGER.info("ProductServiceImpl:saveProduct request from client {} " + Mapper.mapToJsonString(product));
        ProductRequest productRequest = productService.saveProduct(product);
        LOGGER.info("ProductServiceImpl:saveProduct response from service {} " + Mapper.mapToJsonString(productRequest));
        
        if(productRequest == null)
        	return new ResponseEntity<ProductRequest>(HttpStatus.NO_CONTENT);
        
        return new ResponseEntity<ProductRequest>(productRequest, HttpStatus.CREATED);
    }

    @ApiOperation(value = SwaggerConfigValue.VALUE2, response = List.class)
    @GetMapping(value = "/products")
    public ResponseEntity<List<ProductResponse>> getProducts(){
        List<ProductResponse> productResponses = productService.getProducts();
        LOGGER.info("ProductServiceImpl:getProducts response from service {} " + productResponses);
        
        if(productResponses.isEmpty())
        	return new ResponseEntity<List<ProductResponse>>(HttpStatus.NO_CONTENT);
        
        return new ResponseEntity<>(productResponses, HttpStatus.OK);
    }

    @ApiOperation(value = SwaggerConfigValue.VALUE3, response = Optional.class)
    @GetMapping(value = "/products/{productId}")
    public ResponseEntity<Optional<ProductResponse>> getProductById(@PathVariable Integer productId){
        LOGGER.info("ProductServiceImpl:getProductById request from client {} " + productId);
        Optional<ProductResponse> optionalProduct = productService.getProductById(productId);
        LOGGER.info("ProductServiceImpl:getProductById response from service {} " + optionalProduct);
        
        if(optionalProduct.isEmpty())
        	return new ResponseEntity<Optional<ProductResponse>>(HttpStatus.NO_CONTENT);
        
        return new ResponseEntity<Optional<ProductResponse>>(optionalProduct, HttpStatus.OK);
    }
    @PutMapping(value = "/products/{productId}")
    public ResponseEntity<ProductRequest> updateProduct(@PathVariable Integer productId, @RequestBody Product product){
        LOGGER.info("ProductServiceImpl:updateProduct request from client {} " + Mapper.mapToJsonString(product));
        ProductRequest productRequest = productService.updateProduct(productId, product);
        LOGGER.info("ProductServiceImpl:updateProduct response from service {} " + Mapper.mapToJsonString(productRequest));
        
        if(productRequest == null)
        	return new ResponseEntity<ProductRequest>(HttpStatus.NO_CONTENT);
        
        return new ResponseEntity<ProductRequest>(productRequest, HttpStatus.CREATED);
    }
    
    @DeleteMapping(value = "/products/{productId}")
    public ResponseEntity<String> deleteProductById(@PathVariable Integer productId){
    	String deleteProduct = productService.deleteByProductId(productId);
    	LOGGER.warn("ProductServiceImpl:deleteProductById Product Will be Deleted for given product Id {} " + productId + " Returing String data" + deleteProduct);
    	return new ResponseEntity<String>(deleteProduct, HttpStatus.OK);
    }
    
    @DeleteMapping(value = "/products")
    public ResponseEntity<String> deleteAllProducts(){
    	String deleteProduct = productService.deleteAllProducts();
    	LOGGER.warn("ProductServiceImpl:deleteAllProducts All Product Will be Deleted {} " + deleteProduct);
    	return new ResponseEntity<String>(deleteProduct, HttpStatus.OK);
    }
}
