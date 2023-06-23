package com.khube.crm.enquiry.main.openfeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.khube.crm.enquiry.main.response.ProductResponse;

@FeignClient(name = "PRODUCT-SERVICE", path = "${product.service.path}")
public interface ProductFeignClient {
    
	@GetMapping(value = "/products/{productId}")
    public ProductResponse getProductById(@PathVariable Integer productId);
}
