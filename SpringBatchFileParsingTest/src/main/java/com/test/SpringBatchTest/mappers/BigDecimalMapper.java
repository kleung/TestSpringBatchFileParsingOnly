package com.test.SpringBatchTest.mappers;

import java.math.BigDecimal;
import java.text.DecimalFormat;

import com.test.SpringBatchTest.exception.FieldMappingException;

public class BigDecimalMapper implements StringMapper<BigDecimal> {

	protected int decimalPlaces;
	
	public BigDecimalMapper() {
		super();
	}

	public void setDecimalPlaces(int decimalPlaces) {
		this.decimalPlaces = decimalPlaces;
	}
	
	@Override
	public void validateSettings() {
		if(this.decimalPlaces < 0) {
			throw new IllegalArgumentException("Decimal places cannot be less than 0, current value: " + this.decimalPlaces);
		}
	}
	
	protected String generateFormatString() {
		StringBuilder resultBuilder = new StringBuilder("#.");
		
		for(int icounter = 0; icounter < this.decimalPlaces; icounter++) {
			resultBuilder.append("#");
		}
		
		return resultBuilder.toString();
	}

	protected String formDecimalString(String in) {
		int length = in.length();
		int targetDecimalIndex = length - this.decimalPlaces;
		
		String prefix = in.substring(0, targetDecimalIndex);
		
		String postfix = in.substring(targetDecimalIndex, length);
		
		return prefix + "." + postfix;
	}
	
	@Override
	public BigDecimal map(String in) throws FieldMappingException {
		if(in == null) {
			throw new FieldMappingException("Input cannot be null.");
		}
		
		if(in.length() < this.decimalPlaces) {
			throw new FieldMappingException("Input string length cannot be less than decimal places - string: \"" + in + "\" decimal places: " + this.decimalPlaces);
		}
		
		String formattedDecimalString = this.formDecimalString(in);
		String formatString = this.generateFormatString();
		
		BigDecimal result = null;
		
		try {
			DecimalFormat formatter = new DecimalFormat(formatString);
			formatter.setParseBigDecimal(true);
			
			result = (BigDecimal)formatter.parseObject(formattedDecimalString);
		} catch (Exception e) {
			throw new FieldMappingException(e.getMessage(), e);
		}
		
		return result;
	}
}
