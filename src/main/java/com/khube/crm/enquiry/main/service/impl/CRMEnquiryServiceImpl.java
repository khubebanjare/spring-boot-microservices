package com.khube.crm.enquiry.main.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khube.crm.enquiry.main.entity.Enquiry;
import com.khube.crm.enquiry.main.exception.EnquiryAlreadyPresentException;
import com.khube.crm.enquiry.main.exception.EnquiryIsNotPresentException;
import com.khube.crm.enquiry.main.exception.EnquiryNotFoundException;
import com.khube.crm.enquiry.main.helper.EnquiryHelper;
import com.khube.crm.enquiry.main.openfeign.ProductFeignClient;
import com.khube.crm.enquiry.main.repository.EnquiryRepository;
import com.khube.crm.enquiry.main.request.EnquiryRequest;
import com.khube.crm.enquiry.main.response.EnquiryResponse;
import com.khube.crm.enquiry.main.response.ProductResponse;
import com.khube.crm.enquiry.main.service.CRMEnquiryService;
import com.khube.crm.enquiry.main.util.Mapper;

@Service
public class CRMEnquiryServiceImpl implements CRMEnquiryService {

	private static final Logger LOGGER = LogManager.getLogger(CRMEnquiryServiceImpl.class);
	
    @Autowired
    private EnquiryRepository enquiryRepository;
    
    @Autowired
    private EnquiryRequest enquiryRequest;
    
    @Autowired
    private EnquiryResponse enquiryResponse;
    
    @Autowired
    private ProductFeignClient productFeignClient;

    @Override
    public EnquiryRequest createProductEnquiry(Enquiry enquiry) {
    	LOGGER.info("CRMEnquiryServiceImpl:createProductEnquiry execution started...");
        if(enquiryRepository.existsById(enquiry.getEnquiryId()))
        	throw new EnquiryAlreadyPresentException("Enquiry Data is already present...");
        LOGGER.debug("CRMEnquiryServiceImpl:createProductEnquiry Request payload {} " + Mapper.mapToJsonString(enquiry));
    	Enquiry newEnquiry = enquiryRepository.save(enquiry);
        enquiryRequest = EnquiryHelper.setEnquiryDetailsForRequest(newEnquiry);
        LOGGER.debug("CRMEnquiryServiceImpl:createProductEnquiry Response {} " + Mapper.mapToJsonString(enquiryRequest));
        return enquiryRequest;
    }

    @Override
    public List<EnquiryResponse> getEnquiries() {
    	LOGGER.info("CRMEnquiryServiceImpl:getEnquiries execution started...");
    	List<Enquiry> enquiries = enquiryRepository.findAll();
        List<EnquiryResponse> enquiryResponses = new ArrayList<EnquiryResponse>();
        if(!enquiries.isEmpty()){
            enquiries.forEach(enquiry -> {
            	getProductResponse(enquiry);
                enquiryResponses.add(enquiryResponse);
            });
        }
        else
            throw new EnquiryNotFoundException("Enquiry Data not Found!!!!");
        LOGGER.debug("CRMEnquiryServiceImpl:getEnquiries Response {} " + Mapper.mapToJsonString(enquiryResponses));
        return enquiryResponses;
    }

    @Override
    public Optional<EnquiryResponse> getEnquiryById(Integer enquiryId) {
    	LOGGER.info("CRMEnquiryServiceImpl:getEnquiries execution started...");
        Enquiry existEnquiry = enquiryRepository.findById(enquiryId)
                .orElseThrow(
                        () ->  new EnquiryIsNotPresentException("Product is not present for given Product ID!!! : " + enquiryId));
        getProductResponse(existEnquiry);
        Optional<EnquiryResponse> enquiryResponseOptional = Optional.of(enquiryResponse);
        LOGGER.debug("CRMEnquiryServiceImpl:getEnquiryById Response {} " + Mapper.mapToJsonString(enquiryResponseOptional));
        if(enquiryResponseOptional.isPresent())
            return enquiryResponseOptional;
        else
            throw new EnquiryNotFoundException("Enquiry data not found");
    }

	@Override
	public List<EnquiryResponse> findByProductIdAndDateOfEnquiry(Integer productId, LocalDate dateOfEnquiry) {
		LOGGER.info("CRMEnquiryServiceImpl:findByProductIdAndDateOfEnquiry execution started...");
		List<Enquiry> enquiries = enquiryRepository.findByProductIdAndDateOfEnquiry(productId, dateOfEnquiry);
		List<EnquiryResponse> enquiryResponses = new ArrayList<EnquiryResponse>();
		if(!enquiries.isEmpty()){
            enquiries.forEach(enquiry -> {
            	getProductResponse(enquiry);
                enquiryResponses.add(enquiryResponse);
            });
        }
        else
            throw new EnquiryNotFoundException("Enquiry Data not Found for given condition!!!!");
		LOGGER.debug("CRMEnquiryServiceImpl:findByProductIdAndDateOfEnquiry Response {} " + Mapper.mapToJsonString(enquiryResponses));
		return enquiryResponses;
	}
	
	@Override
	public List<EnquiryResponse> findByProductId(Integer productId) {
		LOGGER.info("CRMEnquiryServiceImpl:findByProductId execution started...");
		List<Enquiry> enquiries = enquiryRepository.findByProductId(productId);
		List<EnquiryResponse> enquiryResponses = new ArrayList<EnquiryResponse>();
              
		if(!enquiries.isEmpty()){
            enquiries.forEach(enquiry -> {
            	getProductResponse(enquiry);
                enquiryResponses.add(enquiryResponse);
            });
        }
        else
            throw new EnquiryNotFoundException("Enquiry Data not Found for given condition!!!!");
		LOGGER.debug("CRMEnquiryServiceImpl:findByProductId Response {} " + Mapper.mapToJsonString(enquiryResponses));
		return enquiryResponses;
	}

	
	private void getProductResponse(Enquiry enquiry) {
		enquiryResponse = EnquiryHelper.setEnquiryDetailsForResponse(enquiry);
        ProductResponse productResponse = productFeignClient.getProductById(enquiry.getProductId());
        LOGGER.debug("CRMEnquiryServiceImpl:getProductResponse Response {} " + Mapper.mapToJsonString(productResponse));
        if(productResponse != null)
        	enquiryResponse.setProductResponse(productResponse);
	}

	
}
