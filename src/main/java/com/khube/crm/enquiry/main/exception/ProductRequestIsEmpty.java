package com.khube.crm.enquiry.main.exception;

public class ProductRequestIsEmpty extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ProductRequestIsEmpty() {
	}
	
	public ProductRequestIsEmpty(String message) {
		super(message);
	}
}
