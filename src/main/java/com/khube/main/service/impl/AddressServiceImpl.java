package com.khube.main.service.impl;

import com.khube.main.entity.Address;
import com.khube.main.exception.AddressAlreadyPresent;
import com.khube.main.exception.AddressNotFoundException;
import com.khube.main.helper.AddressHelper;
import com.khube.main.repository.AddressRepository;
import com.khube.main.request.AddressRequest;
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
    private AddressRequest addressRequest;
    
    @Override
    public AddressRequest createAddress(Address address) throws AddressAlreadyPresent{
        Address existAddress = addressRepository.findById(address.getAddressId()).get();
        						
        if(existAddress == null) {
        	 Address newAddress = addressRepository.save(address);
        	 addressRequest = AddressHelper.setAddressDetailsForRequest(newAddress);
        }
        else
            throw new  AddressAlreadyPresent("Address is already present!");
        return addressRequest;
    }

    @Override
    public List<AddressResponse> getAddresses() throws AddressNotFoundException {
        List<Address> addresses = addressRepository.findAll();
        List<AddressResponse> addressResponses = new ArrayList<AddressResponse>();
        if(!addresses.isEmpty()) {
            addresses.forEach(address ->
            {
                addressResponse = AddressHelper.setAddressDetailsForMultiObjectForResponse(address);
                addressResponses.add(addressResponse);
            });
        }
        else
            throw new AddressNotFoundException("Address is Empty");
        return addressResponses;
    }

    @Override
    public Optional<AddressResponse> getAddressByAddressId(Integer addressId) throws AddressNotFoundException {
       Address address = addressRepository.findById(addressId)
    		   				.orElseThrow(() -> new AddressNotFoundException("Address is Not Found for given Address ID!! : " + addressId));
           
       addressResponse = AddressHelper.setAddressDetailsForResponse(address);
       Optional<AddressResponse> optionalAddressResponse = Optional.of(addressResponse);
       
       if(optionalAddressResponse.isPresent())
    	   return optionalAddressResponse;
       else
           throw new AddressNotFoundException("Address is Not Found");
    }

	@Override
	public AddressResponse findAddressByEmpId(Integer empId) throws AddressNotFoundException {
		Address address = addressRepository.findAddressByEmpId(empId);
		if(address != null)
			addressResponse = AddressHelper.setAddressDetailsForResponse(address);
		else
			throw new AddressNotFoundException("Address is Not Found for the given Employee ID!! " + empId);
		return addressResponse;
	}
}
