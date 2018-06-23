package com.test.SpringBatchTest.model;

import java.math.BigDecimal;

public class BatchFileHeader extends AbstractInterfaceFileContent {
	
	protected BigDecimal headerCode;
	
	public BatchFileHeader() {
		super();
	}

	public BigDecimal getHeaderCode() {
		return headerCode;
	}

	public void setHeaderCode(BigDecimal headerCode) {
		this.headerCode = headerCode;
	}
	
}
