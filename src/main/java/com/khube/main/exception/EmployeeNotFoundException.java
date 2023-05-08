package com.khube.main.exception;

public class EmployeeNotFoundException extends Exception{
    public String message;

    public EmployeeNotFoundException(String msg) {
        super(msg);
        this.message = msg;
    }

    public EmployeeNotFoundException(String message, String message1) {
        super(message);
        this.message = message1;
    }
}
