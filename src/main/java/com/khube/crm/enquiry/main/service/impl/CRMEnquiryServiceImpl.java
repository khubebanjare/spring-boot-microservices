package com.khube.crm.enquiry.main.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khube.crm.enquiry.main.entity.Enquiry;
import com.khube.crm.enquiry.main.exception.EnquiryAlreadyPresentException;
import com.khube.crm.enquiry.main.exception.EnquiryIsNotPresent;
import com.khube.crm.enquiry.main.exception.EnquiryNotFoundException;
import com.khube.crm.enquiry.main.helper.EnquiryHelper;
import com.khube.crm.enquiry.main.openfeign.ProductFeignClient;
import com.khube.crm.enquiry.main.repository.EnquiryRepository;
import com.khube.crm.enquiry.main.request.EnquiryRequest;
import com.khube.crm.enquiry.main.response.EnquiryResponse;
import com.khube.crm.enquiry.main.service.CRMEnquiryService;

@Service
public class CRMEnquiryServiceImpl implements CRMEnquiryService {

    @Autowired
    private EnquiryRepository enquiryRepository;
    
    @Autowired
    private EnquiryRequest enquiryRequest;
    
    @Autowired
    private EnquiryResponse enquiryResponse;
    
//    @Autowired
//    private ProductFeignClient productFeignClient;

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

	@Override
	public EnquiryResponse findEnquiryByProductId(Integer productId) {
		Enquiry enquiry = enquiryRepository.findEnquiryByProductId(productId);
		if(enquiry != null)
			enquiryResponse = EnquiryHelper.setEnquiryDetailsForResponse(enquiry);
		else
			throw new EnquiryNotFoundException("Enquiry Data not found");
		return enquiryResponse;
	}

	@Override
	public EnquiryResponse findByproductIdAndDateOfEnquiry(Integer productId, Date dateOfEnquiry) {
		Enquiry enquiry = enquiryRepository.findByproductIdAndDateOfEnquiry(productId, dateOfEnquiry);
		if(enquiry != null)
			enquiryResponse = EnquiryHelper.setEnquiryDetailsForResponse(enquiry);
		else
			throw new EnquiryNotFoundException("Enquiry Data not found");
		return enquiryResponse;
	}
	
}
