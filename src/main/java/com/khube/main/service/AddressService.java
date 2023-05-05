package com.khube.main.service;

import com.khube.main.entity.Address;
import com.khube.main.respones.AddressResponse;

import java.util.List;
import java.util.Optional;

public interface AddressService {

    public AddressResponse createAddress(Address address);

    public List<AddressResponse> getAddresses();

    public Optional<AddressResponse> getAddressByAddressId(Integer addressId);
}
