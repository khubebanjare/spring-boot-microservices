package com.poc.shoppingcart.exception;

public class CartIsEmpty extends RuntimeException{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;

    public CartIsEmpty() {

    }

    public CartIsEmpty(String msg) {
        super(msg);
        this.message = msg;
    }
}
