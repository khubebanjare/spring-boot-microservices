package com.khube.spring.security.main.exception;

public class RoleNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public RoleNotFoundException() {
	}
	
	public RoleNotFoundException(String msg) {
		super(msg);
	}

}
