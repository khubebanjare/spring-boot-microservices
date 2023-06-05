package com.khube.crm.enquiry.main.entity;

import jakarta.persistence.*;

import java.util.Date;

import com.khube.crm.enquiry.main.request.ProductRequest;

@Entity
@Table(name = "enquiry_tab")
public class Enquiry {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer enquiryId;
    private String clientName;
    private Long clientMobileNumber;
    private Date dateOfEnquiry;
    private Integer productId;

    public Enquiry() {
    }

    public Enquiry(Integer enquiryId, String clientName, Long clientMobileNumber, Date dateOfEnquiry, Integer productId) {
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

    @Override
    public String toString() {
        return "Enquiry{" +
                "enquiryId=" + enquiryId +
                ", clientName='" + clientName + '\'' +
                ", clientMobileNumber=" + clientMobileNumber +
                ", dateOfEnquiry=" + dateOfEnquiry +
                ", productId=" + productId +
                '}';
    }
}
