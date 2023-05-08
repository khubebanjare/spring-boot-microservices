package com.khube.main.exception;

public class EmployeeAlreadyPresent extends RuntimeException{
    private String message;

    public EmployeeAlreadyPresent(String msg){
        super(msg);
        this.message = msg;
    }
}
