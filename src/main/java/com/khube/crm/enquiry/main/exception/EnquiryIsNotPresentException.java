package com.khube.crm.enquiry.main.exception;

public class EnquiryIsNotPresentException extends RuntimeException{

    private static final long serialVersionUID = 1L;

	public EnquiryIsNotPresentException(){}

    public EnquiryIsNotPresentException(String message){super(message);}
}
