package com.khube.crm.enquiry.main.openfeign;

import com.khube.crm.enquiry.main.entity.Enquiry;
import com.khube.crm.enquiry.main.response.ProductResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "product-service", url = "http://localhost:8087/product-service/product/api")
public interface ProductFeignClient {

    @PostMapping(value = "/products")
    public ResponseEntity<ProductResponse> createProductEnquiry(@RequestBody Enquiry enquiry);
}
