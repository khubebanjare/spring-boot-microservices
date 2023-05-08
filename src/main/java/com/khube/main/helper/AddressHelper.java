package com.khube.main.helper;

import org.springframework.stereotype.Component;

import com.khube.main.entity.Address;
import com.khube.main.request.AddressRequest;
import com.khube.main.respones.AddressResponse;

@Component
public class AddressHelper {

    private static AddressResponse addressResponse = new AddressResponse();
    private static AddressRequest addressRequest = new AddressRequest();

    public static AddressRequest setAddressDetailsForRequest(Address address) {
    	addressRequest.setAddressId(address.getAddressId());
    	addressRequest.setStreet(address.getStreet());
    	addressRequest.setLine1(address.getLine1());
    	addressRequest.setLine2(address.getLine2());
    	addressRequest.setMarkedLocation(address.getMarkedLocation());
    	addressRequest.setCity(address.getCity());
    	addressRequest.setState(address.getState());
    	addressRequest.setPinCode(address.getPinCode());
    	addressRequest.setCountry(address.getCountry());
        return addressRequest;
    }
    
    public static AddressResponse setAddressDetailsForResponse(Address address){
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

    public static AddressResponse setAddressDetailsForMultiObjectForResponse(Address address){
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
