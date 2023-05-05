package com.poc.shoppingcart.exception;

public class OrderReferenceAlreadyExistsException extends RuntimeException{

    private String message;

    public OrderReferenceAlreadyExistsException(){}
    public OrderReferenceAlreadyExistsException(String msg){
        super(msg);
        this.message = msg;
    }
}
