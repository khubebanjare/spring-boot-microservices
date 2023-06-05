package com.khube.main.product.exception;

public class ProductIsNotPresent extends RuntimeException{

    public ProductIsNotPresent(){}

    public ProductIsNotPresent(String message){
        super(message);
    }
}
