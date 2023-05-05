package com.poc.shoppingcart.exception;

public class ProductOutOfStock extends RuntimeException{

	private static final long serialVersionUID = 1L;
	private String message;

    public ProductOutOfStock() {

    }

    public ProductOutOfStock(String msg) {
        super(msg);
        this.message = msg;
    }
}
