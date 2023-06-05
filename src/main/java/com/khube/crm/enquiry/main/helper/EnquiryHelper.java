package com.khube.crm.enquiry.main.helper;

import com.khube.crm.enquiry.main.entity.Enquiry;
import com.khube.crm.enquiry.main.request.EnquiryRequest;
import com.khube.crm.enquiry.main.response.EnquiryResponse;

public class EnquiryHelper {

    public static EnquiryRequest setEnquiryDetailsForRequest(Enquiry enquiry){
        EnquiryRequest enquiryRequest = new EnquiryRequest();
        enquiryRequest.setEnquiryId(enquiry.getEnquiryId());
        enquiryRequest.setClientName(enquiry.getClientName());
        enquiryRequest.setClientMobileNumber(enquiry.getClientMobileNumber());
        enquiryRequest.setDateOfEnquiry(enquiry.getDateOfEnquiry());
        enquiryRequest.setProductId(enquiry.getProductId());
        return enquiryRequest;
    }

    public static EnquiryResponse setEnquiryDetailsForResponse(Enquiry enquiry){
        EnquiryResponse enquiryResponse = new EnquiryResponse();
        enquiryResponse.setEnquiryId(enquiry.getEnquiryId());
        enquiryResponse.setClientName(enquiry.getClientName());
        enquiryResponse.setClientMobileNumber(enquiry.getClientMobileNumber());
        enquiryResponse.setDateOfEnquiry(enquiry.getDateOfEnquiry());
        enquiryResponse.setProductId(enquiry.getProductId());
        return enquiryResponse;
    }
}
