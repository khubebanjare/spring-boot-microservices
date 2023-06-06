package com.khube.crm.enquiry.main.request;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

@Component
public class EnquiryRequest {

    private Integer enquiryId;
    private String clientName;
    private Long clientMobileNumber;
    private LocalDate dateOfEnquiry;
    private Integer productId;
    
    public EnquiryRequest() {
    }

    public EnquiryRequest(Integer enquiryId, String clientName, Long clientMobileNumber, LocalDate dateOfEnquiry,
    		Integer productId) {
		super();
		this.enquiryId = enquiryId;
		this.clientName = clientName;
		this.clientMobileNumber = clientMobileNumber;
		this.dateOfEnquiry = dateOfEnquiry;
		this.productId = productId;
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

    public Long getClientMobileNumber() {
        return clientMobileNumber;
    }

    public void setClientMobileNumber(Long clientMobileNumber) {
        this.clientMobileNumber = clientMobileNumber;
    }

    public LocalDate getDateOfEnquiry() {
        return dateOfEnquiry;
    }

    public void setDateOfEnquiry(LocalDate dateOfEnquiry) {
        this.dateOfEnquiry = dateOfEnquiry;
    }

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	@Override
	public String toString() {
		return "EnquiryRequest [enquiryId=" + enquiryId + ", clientName=" + clientName + ", clientMobileNumber="
				+ clientMobileNumber + ", dateOfEnquiry=" + dateOfEnquiry + ", productId=" + productId + "]";
	}

}
