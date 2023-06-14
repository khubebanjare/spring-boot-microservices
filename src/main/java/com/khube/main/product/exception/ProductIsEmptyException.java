package com.khube.main.product.exception;

public class ProductIsEmptyException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ProductIsEmptyException() {
	}
	
	public ProductIsEmptyException(String message) {
		super(message);
	}
}
