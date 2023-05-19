package com.khube.spring.security.main.exception;

public class UserAlreadyExistException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public UserAlreadyExistException() {
		
	}
	
	public UserAlreadyExistException(String msg) {
		super(msg);
	}
	
}
