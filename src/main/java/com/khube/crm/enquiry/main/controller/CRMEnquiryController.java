package com.khube.crm.enquiry.main.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.khube.crm.enquiry.main.entity.Enquiry;
import com.khube.crm.enquiry.main.request.EnquiryRequest;
import com.khube.crm.enquiry.main.response.EnquiryResponse;
import com.khube.crm.enquiry.main.response.error.EnquiryErrorResponse;
import com.khube.crm.enquiry.main.service.CRMEnquiryService;
import com.khube.crm.enquiry.main.util.Mapper;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/enquiry/api")
@Tag(name = "CRMEnquiry", description = "This Controller is used to create, search all Enquiries, based on enquiry and product, and based on some condition It will return details of enquiries.")
public class CRMEnquiryController {

	private static final Logger LOGGER = LogManager.getLogger(CRMEnquiryController.class);
	
    @Autowired
    private CRMEnquiryService crmEnquiryService;

    @Operation(summary = "Create a new enquiry", description = "This api is used to create an Enquiry for a Product.")
    @ApiResponses({
        @ApiResponse(responseCode = "201", content = {
                    @Content(schema = @Schema(implementation = EnquiryRequest.class), mediaType = "application/json")
        }),
        @ApiResponse(responseCode = "500", content = {
                    @Content(schema = @Schema(implementation = EnquiryErrorResponse.class), mediaType = "application/json")
        }),
    })
    @PostMapping(value = "/enquiries")
    public ResponseEntity<EnquiryRequest> createProductEnquiry(@RequestBody Enquiry enquiry){
        EnquiryRequest enquiryRequest = crmEnquiryService.createProductEnquiry(enquiry);
        LOGGER.debug("CRMEnquiryController:createProductEnquiry Response {} " + Mapper.mapToJsonString(enquiryRequest));
        return new ResponseEntity<EnquiryRequest>(enquiryRequest, HttpStatus.CREATED);
    }

    @GetMapping(value = "/enquiries")
    public ResponseEntity<List<EnquiryResponse>> getEnquiries(){
        List<EnquiryResponse> enquiryResponses = crmEnquiryService.getEnquiries();
        LOGGER.debug("CRMEnquiryController:getEnquiries Response {} " + Mapper.mapToJsonString(enquiryResponses));
        return new ResponseEntity<List<EnquiryResponse>>(enquiryResponses, HttpStatus.OK);
    }

    @GetMapping(value = "/enquiries/{enquiryId}")
    public ResponseEntity<Optional<EnquiryResponse>> getEnquiryById(@PathVariable Integer enquiryId){
        Optional<EnquiryResponse> enquiryResponseOptional = crmEnquiryService.getEnquiryById(enquiryId);
        LOGGER.debug("CRMEnquiryController:getEnquiryById Response {} " + Mapper.mapToJsonString(enquiryResponseOptional));
        return new ResponseEntity<Optional<EnquiryResponse>>(enquiryResponseOptional, HttpStatus.OK);
    }
    
    @GetMapping(value = "/enquiry")
    public ResponseEntity<List<EnquiryResponse>> findByProductId(
    											@RequestParam("productId") Integer productId, 
    											@RequestParam("dateOfEnquiry") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateOfEnquiry){
    	List<EnquiryResponse> enquiryResponses = crmEnquiryService.findByProductIdAndDateOfEnquiry(productId, dateOfEnquiry);
    	LOGGER.debug("CRMEnquiryController:findEnquiryByProductIdAndDateOfEnquiry Response {} " + Mapper.mapToJsonString(enquiryResponses));
    	return new ResponseEntity<List<EnquiryResponse>>(enquiryResponses, HttpStatus.OK);
    }
    
    @GetMapping(value = "/enquiries/products/{productId}")
    public ResponseEntity<List<EnquiryResponse>> findEnquiryByProductIdAndDateOfEnquiry(@PathVariable Integer productId){
    	List<EnquiryResponse> enquiryResponses = crmEnquiryService.findByProductId(productId);
    	LOGGER.debug("CRMEnquiryController:findEnquiryByProductIdAndDateOfEnquiry Response {} " + Mapper.mapToJsonString(enquiryResponses));
    	return new ResponseEntity<List<EnquiryResponse>>(enquiryResponses, HttpStatus.OK);
    }
}
