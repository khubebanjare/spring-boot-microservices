package com.khube.main.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.khube.main.entity.Address;
import com.khube.main.exception.AddressAlreadyPresent;
import com.khube.main.exception.AddressNotFoundException;
import com.khube.main.exception.AddressNotPresent;
import com.khube.main.request.AddressRequest;
import com.khube.main.respones.AddressResponse;
import com.khube.main.service.AddressService;
import com.khube.main.util.SwaggerConfigValue;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RequestMapping("/address/api")
@RestController
@Api(tags = {"Address Controller"})
@ApiResponses( value = {
        @ApiResponse(message = SwaggerConfigValue.OK, code = 200),
        @ApiResponse(message = SwaggerConfigValue.CREATED, code = 201),
        @ApiResponse(message = SwaggerConfigValue.FORBIDDEN, code = 404),
        @ApiResponse(message = SwaggerConfigValue.NOTFOUND, code = 400),
        @ApiResponse(message = SwaggerConfigValue.UNAUTHORIZED, code = 401),
        @ApiResponse(message = SwaggerConfigValue.INTERNALSERVERERROR, code = 500)
})
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping("/address")
    public String getAddress(){
        return "Raipur, Chhattisgarh";
    }

    @ApiOperation(value = SwaggerConfigValue.VALUE1, response = AddressResponse.class)
    @PostMapping(value = "/addresses")
    public AddressRequest createAddress(@RequestBody Address address)throws AddressAlreadyPresent{
        return addressService.createAddress(address);
    }

    @ApiOperation(value = SwaggerConfigValue.VALUE2, response = List.class)
    @GetMapping(value = "/addresses")
    public List<AddressResponse> getAddresses() throws AddressNotFoundException{
        return addressService.getAddresses();
    }

    @ApiOperation(value = SwaggerConfigValue.VALUE3, response = Optional.class)
    @GetMapping(value = "/addresses/{addressId}")
    public Optional<AddressResponse> getAddressByAddressId(@PathVariable Integer addressId) throws AddressNotPresent, AddressNotFoundException{
        return addressService.getAddressByAddressId(addressId);
    }
    
    @GetMapping("/addresseemp/{empId}")
    public ResponseEntity<AddressResponse> findAddressByEmpId(@PathVariable Integer empId) throws AddressNotFoundException {
    	AddressResponse adddressResponse = addressService.findAddressByEmpId(empId);
    	return new ResponseEntity<AddressResponse>(adddressResponse, HttpStatus.OK);
    }
}
