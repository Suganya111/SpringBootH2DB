package com.aaludra.spring.jpa.h2.exception;

public class ValidationException extends Exception {

	private static final long serialVersionUID = 1L;

	ValidationException(String message) {
		super(message);
	}

}