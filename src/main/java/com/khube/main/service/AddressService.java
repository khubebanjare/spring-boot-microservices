package com.khube.main.service;

import com.khube.main.entity.Address;
import com.khube.main.exception.AddressAlreadyPresent;
import com.khube.main.exception.AddressNotFoundException;
import com.khube.main.exception.AddressNotPresent;
import com.khube.main.request.AddressRequest;
import com.khube.main.respones.AddressResponse;

import java.util.List;
import java.util.Optional;

public interface AddressService {

    public AddressRequest createAddress(Address address) throws AddressAlreadyPresent;

    public List<AddressResponse> getAddresses() throws AddressNotFoundException;

    public Optional<AddressResponse> getAddressByAddressId(Integer addressId) throws AddressNotPresent, AddressNotFoundException;
    
    public AddressResponse findAddressByEmpId(Integer empId) throws AddressNotFoundException;
}
