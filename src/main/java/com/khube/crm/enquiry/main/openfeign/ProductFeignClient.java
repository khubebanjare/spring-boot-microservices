package com.khube.crm.enquiry.main.openfeign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.khube.crm.enquiry.main.request.ProductRequest;
import com.khube.crm.enquiry.main.response.ProductResponse;

@FeignClient(name = "product-service", url = "${product.service.base.url}")
public interface ProductFeignClient {

    @PostMapping(value = "/products/{productId}")
    public ProductRequest getProductById(@PathVariable Integer productId);
    
    
    public ProductResponse findProductByEnquiryId(@PathVariable() Integer enquiryId);
    
    
}
