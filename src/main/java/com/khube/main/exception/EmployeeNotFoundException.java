package com.khube.main.exception;

public class EmployeeNotFoundException extends RuntimeException{
    public String message;

    public EmployeeNotFoundException(String msg) {
        super(msg);
        this.message = msg;
    }

    public EmployeeNotFoundException(String message, String message1) {
        super(message);
        this.message = message1;
    }

    public EmployeeNotFoundException(String message, Throwable cause, String message1) {
        super(message, cause);
        this.message = message1;
    }

    public EmployeeNotFoundException(Throwable cause, String message) {
        super(cause);
        this.message = message;
    }

    public EmployeeNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String message1) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.message = message1;
    }
}
