package com.poc.shoppingcart.exception;

public class ProductAlreadyExistsException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String message;
	
	public ProductAlreadyExistsException() {
		
	}
	
	public ProductAlreadyExistsException(String msg) {
		super(msg);
		this.message = msg;
	}
}
