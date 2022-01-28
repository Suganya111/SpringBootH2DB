package com.aaludra.spring.jpa.h2.exception;

public class DataNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	DataNotFoundException(String message) {
		super(message);
	}

}
