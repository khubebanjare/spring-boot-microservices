package com.khube.main.service.impl;

import com.khube.main.entity.Address;
import com.khube.main.exception.AddressNotFoundException;
import com.khube.main.exception.AddressNotPresent;
import com.khube.main.helper.AddressHelper;
import com.khube.main.repository.AddressRepository;
import com.khube.main.respones.AddressResponse;
import com.khube.main.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private AddressResponse addressResponse;
    @Override
    public AddressResponse createAddress(Address address) {
        Address newAddress = addressRepository.save(address);
        if(newAddress != null)
            addressResponse = AddressHelper.setAddressDetails(newAddress);
        else
            throw new AddressNotPresent("Address is empty Please provide address details");
        return addressResponse;
    }

    @Override
    public List<AddressResponse> getAddresses() {
        List<Address> addresses = addressRepository.findAll();
        List<AddressResponse> addressResponses = new ArrayList<AddressResponse>();
        if(!addresses.isEmpty()) {
            addresses.forEach(address ->
            {
                addressResponse = AddressHelper.setAddressDetailsForMultiObject(address);
                addressResponses.add(addressResponse);
            });
        }
        else
            throw new AddressNotPresent("Address is Empty");
        return addressResponses;
    }

    @Override
    public Optional<AddressResponse> getAddressByAddressId(Integer addressId) {
       Address address = addressRepository.findById(addressId).get();
       if(address != null){
           addressResponse = AddressHelper.setAddressDetails(address);
           Optional<AddressResponse> optionalAddressResponse = Optional.of(addressResponse);
           if (optionalAddressResponse.isPresent()){
               return optionalAddressResponse;
           }
           else
               throw new AddressNotFoundException("Address is Not Found for given Address ID");
       }
       else
           throw new AddressNotFoundException("Address is Not Found for given Address ID");
    }

	@Override
	public AddressResponse findAddressByEmpId(Integer empId) {
		Address address = addressRepository.findAddressByEmpId(empId);
		AddressResponse addressResponse = AddressHelper.setAddressDetails(address);
		return addressResponse;
	}
}
