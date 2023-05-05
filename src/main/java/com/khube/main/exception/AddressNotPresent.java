package com.khube.main.exception;

public class AddressNotPresent extends RuntimeException{

    private String message;

    public AddressNotPresent(String msg){
        super(msg);
        this.message = msg;
    }

    public AddressNotPresent(String message, String message1) {
        super(message);
        this.message = message1;
    }

    public AddressNotPresent(String message, Throwable cause, String message1) {
        super(message, cause);
        this.message = message1;
    }

    public AddressNotPresent(Throwable cause, String message) {
        super(cause);
        this.message = message;
    }

    public AddressNotPresent(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String message1) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.message = message1;
    }
}
