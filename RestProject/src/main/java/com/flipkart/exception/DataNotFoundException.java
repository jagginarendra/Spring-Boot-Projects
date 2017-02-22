package com.flipkart.exception;

public class DataNotFoundException extends RuntimeException {

	
	private static final long serialVersionUID = 1L;

	
	public DataNotFoundException(String message) {
		
		super(message);
	}
	
}
