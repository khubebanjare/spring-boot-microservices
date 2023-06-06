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
import com.khube.crm.enquiry.main.service.CRMEnquiryService;
import com.khube.crm.enquiry.main.util.Mapper;

@RestController
@RequestMapping("/enquiry/api")
public class CRMEnquiryController {

	private static final Logger LOGGER = LogManager.getLogger(CRMEnquiryController.class);
	
    @Autowired
    private CRMEnquiryService crmEnquiryService;

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
    public ResponseEntity<List<EnquiryResponse>> findEnquiryByProductIdAndDateOfEnquiry(
    											@RequestParam("productId") Integer productId, 
    											@RequestParam("dateOfEnquiry") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateOfEnquiry){
    	List<EnquiryResponse> enquiryResponses = crmEnquiryService.findByProductIdAndDateOfEnquiry(productId, dateOfEnquiry);
    	LOGGER.debug("CRMEnquiryController:findEnquiryByProductIdAndDateOfEnquiry Response {} " + Mapper.mapToJsonString(enquiryResponses));
    	return new ResponseEntity<List<EnquiryResponse>>(enquiryResponses, HttpStatus.OK);
    }
}
