package com.test.SpringBatchTest.exception;

public class FieldMappingException extends RuntimeException {
	
	private static final long serialVersionUID = 8674283131299228929L;

	public FieldMappingException(String message) {
		super(message);
	}
	
	public FieldMappingException(String message, Throwable cause) {
		super(message, cause);
	}

}
