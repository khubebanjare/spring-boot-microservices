package com.khube.main.controller;

import com.khube.main.entity.Address;
import com.khube.main.respones.AddressResponse;
import com.khube.main.service.AddressService;
import com.khube.main.util.SwaggerConfigValue;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public AddressResponse createAddress(@RequestBody Address address){
        return addressService.createAddress(address);
    }

    @ApiOperation(value = SwaggerConfigValue.VALUE2, response = List.class)
    @GetMapping(value = "/addresses")
    public List<AddressResponse> getAddresses(){
        return addressService.getAddresses();
    }

    @ApiOperation(value = SwaggerConfigValue.VALUE3, response = Optional.class)
    @GetMapping(value = "/addresses/{addressId}")
    public Optional<AddressResponse> getAddressByAddressId(@PathVariable Integer addressId){
        return addressService.getAddressByAddressId(addressId);
    }
}
