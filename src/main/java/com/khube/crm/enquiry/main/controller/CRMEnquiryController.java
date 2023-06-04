package com.khube.crm.enquiry.main.controller;

import com.khube.crm.enquiry.main.entity.Enquiry;
import com.khube.crm.enquiry.main.repository.EnquiryRepository;
import com.khube.crm.enquiry.main.request.EnquiryRequest;
import com.khube.crm.enquiry.main.response.EnquiryResponse;
import com.khube.crm.enquiry.main.service.CRMEnquiryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/enquiry/api")
public class CRMEnquiryController {

    @Autowired
    private CRMEnquiryService crmEnquiryService;

    @PostMapping(value = "/enquiries")
    public ResponseEntity<EnquiryRequest> createProductEnquiry(@RequestBody Enquiry enquiry){
        EnquiryRequest enquiryRequest = crmEnquiryService.createProductEnquiry(enquiry);
        return new ResponseEntity<EnquiryRequest>(enquiryRequest, HttpStatus.CREATED);
    }

    @GetMapping(value = "/enquiries")
    public ResponseEntity<List<EnquiryResponse>> getEnquiries(){
        List<EnquiryResponse> enquiryResponses = crmEnquiryService.getEnquiries();
        return new ResponseEntity<List<EnquiryResponse>>(enquiryResponses, HttpStatus.OK);
    }

    @GetMapping(value = "/enquiries/{enquiryId}")
    public ResponseEntity<Optional<EnquiryResponse>> getEnquiryById(@PathVariable Integer enquiryId){
        Optional<EnquiryResponse> enquiryResponseOptional = crmEnquiryService.getEnquiryById(enquiryId);
        return new ResponseEntity<Optional<EnquiryResponse>>(enquiryResponseOptional, HttpStatus.OK);
    }
}
