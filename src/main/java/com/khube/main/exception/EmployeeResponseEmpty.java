package com.khube.main.exception;

public class EmployeeResponseEmpty extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public EmployeeResponseEmpty(String msg){
        super(msg);
    }

    public EmployeeResponseEmpty(String message, String message1) {
        super(message);
    }

}
