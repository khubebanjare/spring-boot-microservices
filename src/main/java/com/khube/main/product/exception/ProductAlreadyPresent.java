package com.khube.main.product.exception;

public class ProductAlreadyPresent extends RuntimeException{
    public ProductAlreadyPresent(){}

    public ProductAlreadyPresent(String message){
        super(message);
    }
}
