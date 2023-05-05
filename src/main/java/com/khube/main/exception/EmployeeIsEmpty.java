package com.khube.main.exception;

public class EmployeeIsEmpty extends RuntimeException{
    private String message;

    public EmployeeIsEmpty(String msg){
        super(msg);
        this.message = msg;
    }

    public EmployeeIsEmpty(String message, String message1) {
        super(message);
        this.message = message1;
    }

    public EmployeeIsEmpty(String message, Throwable cause, String message1) {
        super(message, cause);
        this.message = message1;
    }

    public EmployeeIsEmpty(Throwable cause, String message) {
        super(cause);
        this.message = message;
    }

    public EmployeeIsEmpty(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String message1) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.message = message1;
    }
}
