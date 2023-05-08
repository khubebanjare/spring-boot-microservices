package com.khube.main.exception;

public class AddressAlreadyPresent extends Exception{
    
	private static final long serialVersionUID = 1L;
	
	public AddressAlreadyPresent(String msg){
        super(msg);
    }
}
