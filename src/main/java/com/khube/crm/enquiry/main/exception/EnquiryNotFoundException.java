package com.khube.crm.enquiry.main.exception;

public class EnquiryNotFoundException extends RuntimeException{

    private static final long serialVersionUID = 1L;

	public EnquiryNotFoundException(){}

    public EnquiryNotFoundException(String message){super(message);}
}
