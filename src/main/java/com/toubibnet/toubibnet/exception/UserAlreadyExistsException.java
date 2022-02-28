package com.toubibnet.toubibnet.exception;


public class UserAlreadyExistsException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1425823143361197218L;
	
	public UserAlreadyExistsException() {
		super("user already exists");
	}
	public UserAlreadyExistsException(String message) {
		super(message);
	}


}
