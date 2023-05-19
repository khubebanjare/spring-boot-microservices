package com.khube.spring.security.main.exception;

public class RoleAlreadyExistException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public RoleAlreadyExistException() {
	}
	
	public RoleAlreadyExistException(String msg) {
		super(msg);
	}

}
