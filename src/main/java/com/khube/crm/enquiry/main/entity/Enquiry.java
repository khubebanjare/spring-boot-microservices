package com.khube.crm.enquiry.main.entity;

import java.io.Serializable;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "enquiry_tab")
public class Enquiry implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer enquiryId;
    private String clientName;
    private Long clientMobileNumber;
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd ")
    private LocalDate dateOfEnquiry;
    private Integer productId;

    public Enquiry() {
    }

    public Enquiry(Integer enquiryId, String clientName, Long clientMobileNumber, LocalDate dateOfEnquiry, Integer productId) {
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
        return "Enquiry{" +
                "enquiryId=" + enquiryId +
                ", clientName='" + clientName + '\'' +
                ", clientMobileNumber=" + clientMobileNumber +
                ", dateOfEnquiry=" + dateOfEnquiry +
                ", productId=" + productId +
                '}';
    }
}
