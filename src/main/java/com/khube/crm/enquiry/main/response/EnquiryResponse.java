package com.khube.crm.enquiry.main.response;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class EnquiryResponse {

    private Integer enquiryId;
    private String clientName;
    private Long clientMobileNumber;
    private Date dateOfEnquiry;
    private Integer productId;
    private ProductResponse productResponse;
    
    public EnquiryResponse() {
    }

    public EnquiryResponse(Integer enquiryId, String clientName, Long clientMobileNumber, Date dateOfEnquiry,
                           Integer productId, ProductResponse productResponse) {
		this.enquiryId = enquiryId;
		this.clientName = clientName;
		this.clientMobileNumber = clientMobileNumber;
		this.dateOfEnquiry = dateOfEnquiry;
        this.productId = productId;
		this.productResponse = productResponse;
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

    public Date getDateOfEnquiry() {
        return dateOfEnquiry;
    }

    public void setDateOfEnquiry(Date dateOfEnquiry) {
        this.dateOfEnquiry = dateOfEnquiry;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public ProductResponse getProductResponse() {
		return productResponse;
	}

	public void setProductResponse(ProductResponse productResponse) {
		this.productResponse = productResponse;
	}

    @Override
    public String toString() {
        return "EnquiryResponse{" +
                "enquiryId=" + enquiryId +
                ", clientName='" + clientName + '\'' +
                ", clientMobileNumber=" + clientMobileNumber +
                ", dateOfEnquiry=" + dateOfEnquiry +
                ", productId=" + productId +
                ", productResponse=" + productResponse +
                '}';
    }
}
