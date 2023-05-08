package com.khube.main.exception;

public class EmployeeIsNotPresent extends Exception{
    private String message;

    public EmployeeIsNotPresent(String msg){
        super(msg);
        this.message = msg;
    }

    public EmployeeIsNotPresent(String message, String message1) {
        super(message);
        this.message = message1;
    }
}
