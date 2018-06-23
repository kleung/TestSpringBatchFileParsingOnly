package com.test.SpringBatchTest.mappers;

import com.test.SpringBatchTest.exception.FieldMappingException;

public interface StringMapper<T> {

	public void validateSettings();
	
	public T map(String in) throws FieldMappingException;
}
