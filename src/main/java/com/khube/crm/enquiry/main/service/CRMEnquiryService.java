package com.khube.crm.enquiry.main.service;

import com.khube.crm.enquiry.main.entity.Enquiry;
import com.khube.crm.enquiry.main.request.EnquiryRequest;
import com.khube.crm.enquiry.main.response.EnquiryResponse;
import com.khube.crm.enquiry.main.response.ProductResponse;

import java.util.List;
import java.util.Optional;

public interface CRMEnquiryService {

    public EnquiryRequest createProductEnquiry(Enquiry enquiry);

    public List<EnquiryResponse> getEnquiries();

    public Optional<EnquiryResponse> getEnquiryById(Integer enquiryId);
}
