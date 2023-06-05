package com.khube.crm.enquiry.main.service.impl;

import com.khube.crm.enquiry.main.entity.Enquiry;
import com.khube.crm.enquiry.main.exception.EnquiryAlreadyPresentException;
import com.khube.crm.enquiry.main.exception.EnquiryIsNotPresent;
import com.khube.crm.enquiry.main.exception.EnquiryNotFoundException;
import com.khube.crm.enquiry.main.helper.EnquiryHelper;
import com.khube.crm.enquiry.main.repository.EnquiryRepository;
import com.khube.crm.enquiry.main.request.EnquiryRequest;
import com.khube.crm.enquiry.main.response.EnquiryResponse;
import com.khube.crm.enquiry.main.service.CRMEnquiryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CRMEnquiryServiceImpl implements CRMEnquiryService {

    @Autowired
    private EnquiryRepository enquiryRepository;

    @Autowired
    private EnquiryRequest enquiryRequest;

    @Autowired
    private EnquiryResponse enquiryResponse;

    @Override
    public EnquiryRequest createProductEnquiry(Enquiry enquiry) {
        if(enquiryRepository.existsById(enquiry.getEnquiryId()))
        	throw new EnquiryAlreadyPresentException("Enquiry Data is already present...");
        
    	Enquiry newEnquiry = enquiryRepository.save(enquiry);
        enquiryRequest = EnquiryHelper.setEnquiryDetailsForRequest(newEnquiry);
        return enquiryRequest;
    }

    @Override
    public List<EnquiryResponse> getEnquiries() {
        List<Enquiry> enquiries = enquiryRepository.findAll();
        List<EnquiryResponse> enquiryResponses = new ArrayList<EnquiryResponse>();
        if(!enquiries.isEmpty()){
            enquiries.forEach(enquiry -> {
                enquiryResponse = EnquiryHelper.setEnquiryDetailsForResponse(enquiry);
                enquiryResponses.add(enquiryResponse);
            });
        }
        else
            throw new EnquiryNotFoundException("Enquiry Data not Found!!!!");
        return enquiryResponses;
    }

    @Override
    public Optional<EnquiryResponse> getEnquiryById(Integer enquiryId) {
        Enquiry existEnquiry = enquiryRepository.findById(enquiryId)
                .orElseThrow(
                        () ->  new EnquiryIsNotPresent("Product is not present for given Product ID!!! : " + enquiryId));
        enquiryResponse = EnquiryHelper.setEnquiryDetailsForResponse(existEnquiry);
        Optional<EnquiryResponse> enquiryResponseOptional = Optional.of(enquiryResponse);
        if(enquiryResponseOptional.isPresent())
            return enquiryResponseOptional;
        else
            throw new EnquiryNotFoundException("Enquiry data not found");
    }
}
