package com.khube.main.product.exception;

public class ProductIsNotPresent extends RuntimeException{

    private static final long serialVersionUID = 1L;

	public ProductIsNotPresent(){}

    public ProductIsNotPresent(String message){
        super(message);
    }
}
