package com.khube.crm.enquiry.main.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "enquiry_tab")
public class Enquiry {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer enquiryId;
    private String clientName;
    private String clientMobileNumber;
    private Date dateOfEnquiry;

    public Enquiry() {
    }

    public Enquiry(Integer enquiryId, String clientName, String clientMobileNumber, Date dateOfEnquiry) {
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
        return "Enquiry{" +
                "enquiryId=" + enquiryId +
                ", clientName='" + clientName + '\'' +
                ", clientMobileNumber='" + clientMobileNumber + '\'' +
                ", dateOfEnquiry=" + dateOfEnquiry +
                '}';
    }
}
