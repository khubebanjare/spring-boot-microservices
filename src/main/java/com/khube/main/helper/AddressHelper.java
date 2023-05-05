package com.khube.main.helper;

import com.khube.main.entity.Address;
import com.khube.main.respones.AddressResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddressHelper {

    private static AddressResponse addressResponse = new AddressResponse();

    public static AddressResponse setAddressDetails(Address address){
        addressResponse.setAddressId(address.getAddressId());
        addressResponse.setStreet(address.getStreet());
        addressResponse.setLine1(address.getLine1());
        addressResponse.setLine2(address.getLine2());
        addressResponse.setMarkedLocation(address.getMarkedLocation());
        addressResponse.setCity(address.getCity());
        addressResponse.setState(address.getState());
        addressResponse.setPinCode(address.getPinCode());
        addressResponse.setCountry(address.getCountry());
        return addressResponse;
    }

    public static AddressResponse setAddressDetailsForMultiObject(Address address){
        AddressResponse addressResponse = new AddressResponse();
        addressResponse.setAddressId(address.getAddressId());
        addressResponse.setStreet(address.getStreet());
        addressResponse.setLine1(address.getLine1());
        addressResponse.setLine2(address.getLine2());
        addressResponse.setMarkedLocation(address.getMarkedLocation());
        addressResponse.setCity(address.getCity());
        addressResponse.setState(address.getState());
        addressResponse.setPinCode(address.getPinCode());
        addressResponse.setCountry(address.getCountry());
        return addressResponse;
    }
}
