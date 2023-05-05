package com.poc.shoppingcart.exception;

public class ProductNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String message;
	
	public ProductNotFoundException() {
		
	}
	
	public ProductNotFoundException(String msg) {
		super(msg);
		this.message = msg;
	}
	
}
