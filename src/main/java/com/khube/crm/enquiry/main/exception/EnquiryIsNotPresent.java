package com.khube.crm.enquiry.main.exception;

public class EnquiryIsNotPresent extends RuntimeException{

    private static final long serialVersionUID = 1L;

	public EnquiryIsNotPresent(){}

    public EnquiryIsNotPresent(String message){super(message);}
}
