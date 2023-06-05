package com.khube.crm.enquiry.main.response;

import java.util.Date;

public class EnquiryResponse {

    private Integer enquiryId;
    private String clientName;
    private String clientMobileNumber;
    private Date dateOfEnquiry;

    public EnquiryResponse() {
    }

    public EnquiryResponse(Integer enquiryId, String clientName, String clientMobileNumber, Date dateOfEnquiry) {
        this.enquiryId = enquiryId;
        this.clientName = clientName;
        this.clientMobileNumber = clientMobileNumber;
        this.dateOfEnquiry = dateOfEnquiry;
    }

    public Integer getEnquiryId() {
        return enquiryId;
    }

    public void setEnquiryId(Integer enquiryId) {
        this.enquiryId = enquiryId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientMobileNumber() {
        return clientMobileNumber;
    }

    public void setClientMobileNumber(String clientMobileNumber) {
        this.clientMobileNumber = clientMobileNumber;
    }

    public Date getDateOfEnquiry() {
        return dateOfEnquiry;
    }

    public void setDateOfEnquiry(Date dateOfEnquiry) {
        this.dateOfEnquiry = dateOfEnquiry;
    }

    @Override
    public String toString() {
        return "EnquiryResponse{" +
                "enquiryId=" + enquiryId +
                ", clientName='" + clientName + '\'' +
                ", clientMobileNumber='" + clientMobileNumber + '\'' +
                ", dateOfEnquiry=" + dateOfEnquiry +
                '}';
    }
}
