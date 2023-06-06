package com.khube.main.product.exception;

public class ProductAlreadyPresent extends RuntimeException{
    private static final long serialVersionUID = 1L;

	public ProductAlreadyPresent(){}

    public ProductAlreadyPresent(String message){
        super(message);
    }
}
