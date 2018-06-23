package com.test.SpringBatchTest.model;

public class BatchFileFooter extends AbstractInterfaceFileContent {

	protected String checksum;
	
	public BatchFileFooter() {
		super();
	}

	public String getChecksum() {
		return checksum;
	}

	public void setChecksum(String checksum) {
		this.checksum = checksum;
	}
	
}
