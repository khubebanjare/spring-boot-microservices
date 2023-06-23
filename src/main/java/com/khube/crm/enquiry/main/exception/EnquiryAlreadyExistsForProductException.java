package com.khube.crm.enquiry.main.exception;

public class EnquiryAlreadyExistsForProductException extends RuntimeException {
    public EnquiryAlreadyExistsForProductException() {
    }
    public EnquiryAlreadyExistsForProductException(String message) {
        super(message);
    }
}
