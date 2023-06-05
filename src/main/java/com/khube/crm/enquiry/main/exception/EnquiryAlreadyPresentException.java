package com.khube.crm.enquiry.main.exception;

public class EnquiryAlreadyPresentException extends RuntimeException{

    private static final long serialVersionUID = 1L;

	public EnquiryAlreadyPresentException(){}

    public EnquiryAlreadyPresentException(String message){super(message);}
}
