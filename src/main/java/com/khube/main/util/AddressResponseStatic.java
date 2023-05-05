package com.khube.main.util;

import com.khube.main.respones.AddressResponse;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddressResponseStatic {

    private static AddressResponse addressResponse;
    @Autowired
    private AddressResponse addressResponseInstance;

    @PostConstruct
    public void initStaticAddressResponse(){
        addressResponse = this.addressResponseInstance;
    }
}
