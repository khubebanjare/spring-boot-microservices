package com.khube.main.exception;

public class AddressNotFoundException extends RuntimeException{

    private String message;

    public AddressNotFoundException(String msg){
        super(msg);
        this.message = msg;
    }

    public AddressNotFoundException(String message, String message1) {
        super(message);
        this.message = message1;
    }

    public AddressNotFoundException(String message, Throwable cause, String message1) {
        super(message, cause);
        this.message = message1;
    }

    public AddressNotFoundException(Throwable cause, String message) {
        super(cause);
        this.message = message;
    }

    public AddressNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String message1) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.message = message1;
    }
}
