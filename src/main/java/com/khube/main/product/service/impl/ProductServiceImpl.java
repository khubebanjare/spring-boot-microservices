package com.khube.main.product.service.impl;

import com.khube.main.product.entity.Product;
import com.khube.main.product.exception.ProductAlreadyPresent;
import com.khube.main.product.exception.ProductIsEmptyException;
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
       if(productRepository.existsById(product.getProductId())) {
    	   LOGGER.warn("ProductServiceImpl:saveProduct Product Already present...");
    	   throw new ProductAlreadyPresent("Product Already present...");
       }

        LOGGER.debug("ProductServiceImpl:saveProduct Request payload {} " + Mapper.mapToJsonString(product));
       Product newProduct = productRepository.save(product);
        LOGGER.debug("ProductServiceImpl:saveProduct response payload {} " + Mapper.mapToJsonString(product));
       productRequest = ProductHelper.setProductDetailsForRequest(newProduct);
        LOGGER.debug("ProductServiceImpl:saveProduct Response {} " + Mapper.mapToJsonString(product));
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
        else {
        	LOGGER.warn("ProductServiceImpl:getProducts Product Not Found....");
            throw new ProductNotFoundException("Product Not Found");
        }
        return productResponses;
    }

    // hello new line added on this project
    @Override
    public Optional<ProductResponse> getProductById(Integer productId) {
    	System.out.println("Calling Product-Service for Product by Product Id : " + productId);
    	
        LOGGER.info("ProductServiceImpl:getProductById execution started....");
        Product existProduct = productRepository.findById(productId)
                                .orElseThrow(
                                () -> new ProductIsNotPresent("Product is not present for given Product ID!!! : " + productId));
        LOGGER.warn("Product is not present for given Product ID!!! : " + productId);
        productResponse = ProductHelper.setProductDetailsForResponse(existProduct);
        LOGGER.info("ProductServiceImpl:getProductById converting response type {} " + productResponse);
        Optional<ProductResponse> productResponseOptional = Optional.of(productResponse);
        LOGGER.info("ProductServiceImpl:getProductById adding in optional class {} " + productResponse);
        if(productResponseOptional.isPresent())
            return productResponseOptional;
        else {
        	LOGGER.warn("ProductServiceImpl:getProductById Product Not Found got given product Id : " + productId);
            throw new ProductNotFoundException("Product Not Found");
        }
    }

	@Override
	public ProductRequest updateProduct(Integer productId, Product product) {
		LOGGER.info("ProductServiceImpl:updateProduct execution started....");
		LOGGER.debug("ProductServiceImpl:updateProduct Request payload {} " + Mapper.mapToJsonString(product));
		if( productRepository.findById(productId).isPresent()) {
			Product updatedProduct = productRepository.save(product);
			LOGGER.debug("ProductServiceImpl:updateProduct Request payload {} " + "Update Product for productId : " + productId + Mapper.mapToJsonString(product));
			productRequest = ProductHelper.setProductDetailsForRequest(updatedProduct);
			LOGGER.debug("ProductServiceImpl:updateProduct Request payload {} " + Mapper.mapToJsonString(product));
		}
		else{
			Product newProduct = productRepository.save(product);
	        LOGGER.debug("ProductServiceImpl:updateProduct response payload {} " + Mapper.mapToJsonString(product));
	        productRequest = ProductHelper.setProductDetailsForRequest(newProduct);
	        LOGGER.debug("ProductServiceImpl:updateProduct Response {} " + Mapper.mapToJsonString(product));
		}
		return productRequest;
	}

	@Override
	public String deleteByProductId(Integer productId) {
		LOGGER.info("ProductServiceImpl:deleteByProductId execution started....");
		if( productRepository.findById(productId).isPresent()) {
			productRepository.deleteById(productId);
			LOGGER.debug("ProductServiceImpl:deleteByProductId Request payload {} " + productId);
		}
		else {
			LOGGER.warn("ProductServiceImpl:deleteByProductId Product cannot be deleted for given product Id : " + productId);
			throw new ProductIsNotPresent("Product cannot be deleted for given product Id : " + productId);
		}
		return "Product is deleted for given productId : " + productId;
	}

	@Override
	public String deleteAllProducts() {
		LOGGER.info("ProductServiceImpl:deleteAllProducts execution started....");
		List<Product> products = productRepository.findAll();
		if(!products.isEmpty()) {
			productRepository.deleteAll();
			LOGGER.warn("ProductServiceImpl:deleteAllProducts All Product are Deleted!!! payload {} " + products);
		}
		else {
			LOGGER.warn("ProductServiceImpl:deleteAllProducts Product cannot be deleted!!!!: " + products);
			throw new ProductIsEmptyException("Product cannot be deleted!!!");
		}
		return "All Product is deleted!!!";
	}
}

