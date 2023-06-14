package com.khube.crm.enquiry.main.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.khube.crm.enquiry.main.entity.Enquiry;
import com.khube.crm.enquiry.main.request.EnquiryRequest;
import com.khube.crm.enquiry.main.response.EnquiryResponse;

public interface CRMEnquiryService {

    public EnquiryRequest createProductEnquiry(Enquiry enquiry);

    public List<EnquiryResponse> getEnquiries();

    public Optional<EnquiryResponse> getEnquiryById(Integer enquiryId);
    
    public List<EnquiryResponse> findByProductIdAndDateOfEnquiry(Integer productId, LocalDate dateOfEnquiry);
    
    public List<EnquiryResponse> findByProductId(Integer productId);
}
