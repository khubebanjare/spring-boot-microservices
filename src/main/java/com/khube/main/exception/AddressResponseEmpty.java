package com.khube.main.exception;

public class AddressResponseEmpty extends Exception {
    private String message;

    public AddressResponseEmpty(String msg){
        super(msg);
        this.message = msg;
    }

    public AddressResponseEmpty(String message, String message1) {
        super(message);
        this.message = message1;
    }

    public AddressResponseEmpty(String message, Throwable cause, String message1) {
        super(message, cause);
        this.message = message1;
    }

    public AddressResponseEmpty(Throwable cause, String message) {
        super(cause);
        this.message = message;
    }

    public AddressResponseEmpty(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String message1) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.message = message1;
    }
}
