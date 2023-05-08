package com.khube.main.exception;

public class AddressNotFoundException extends Exception{
  
	private static final long serialVersionUID = 1L;
	
	public AddressNotFoundException(String msg){
        super(msg);
    }

    public AddressNotFoundException(String message, String message1) {
        super(message);
    }
}
