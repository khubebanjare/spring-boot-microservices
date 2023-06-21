package com.khube.api.gateway.main.apigateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackController {

    @GetMapping("/productServiceFallBack")
    public String productServiceFallBack(){
        return "Product Service is Down at that time !!!!";
    }

    @GetMapping("/crmenquiryServiceFallBack")
    public String crmenquiryServiceFallBack(){
        return "CRMEnquiry Service is Down at that time !!!!";
    }

    @GetMapping("/addressServiceFallBack")
    public String addressServiceFallBack(){
        return "Address Service is Down at that time !!!!";
    }

    @GetMapping("/employeeServiceFallBack")
    public String employeeServiceFallBack(){
        return "Employee Service is Down at that time !!!!";
    }
}
