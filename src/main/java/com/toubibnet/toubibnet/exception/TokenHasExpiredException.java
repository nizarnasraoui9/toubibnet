package com.toubibnet.toubibnet.exception;

public class TokenHasExpiredException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7331988248156806436L;
	public TokenHasExpiredException() {
		super("token has expired");
	}
	public TokenHasExpiredException(String message) {
		super(message);
	}

}
