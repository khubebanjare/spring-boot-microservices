package com.khube.main.exception;

public class AddressNotPresent extends Exception{

	private static final long serialVersionUID = 1L;
	
    public AddressNotPresent(String msg){
        super(msg);
    }

    public AddressNotPresent(String message, String message1) {
        super(message);
    }
}
