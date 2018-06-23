package com.test.SpringBatchTest.model;

import java.math.BigDecimal;

public class BatchRecord extends AbstractInterfaceFileContent {

	protected BigDecimal value;
	
	protected String person;
	
	protected String purpose;
	
	public BatchRecord() {
		super();
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public String getPerson() {
		return person;
	}

	public void setPerson(String person) {
		this.person = person;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	
}
