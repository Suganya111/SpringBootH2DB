package com.aaludra.spring.jpa.h2.exception;

public class ResourceNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	public  ResourceNotFoundException(String message) {
		super(message);
	}
	public  ResourceNotFoundException(String message, Throwable throwable) {
		super(message, throwable);
	}


}
