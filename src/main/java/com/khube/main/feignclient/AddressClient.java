package com.khube.main.feignclient;

import com.khube.main.response.AddressResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "address-service", url = "http://localhost:8083/address-service/address/api")
public interface AddressClient {

    @GetMapping("/addresseemp/{empId}")
    public AddressResponse findAddressByEmpId(@PathVariable("empId") Integer empId);
}
