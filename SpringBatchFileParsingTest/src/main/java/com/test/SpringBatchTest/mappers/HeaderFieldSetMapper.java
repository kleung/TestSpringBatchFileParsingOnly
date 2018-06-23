package com.test.SpringBatchTest.mappers;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import com.test.SpringBatchTest.model.BatchFileHeader;

public class HeaderFieldSetMapper implements FieldSetMapper<BatchFileHeader> {
	
	protected BigDecimalMapper decimalMapper;
	
	public static final String TYPE_COLUMN = "TYPE";
	
	public static final String HEADER_CODE = "headerCode";
	
	public HeaderFieldSetMapper() {
		super();
	}

	public void setDecimalMapper(BigDecimalMapper decimalMapper) {
		this.decimalMapper = decimalMapper;
	}

	@Override
	public BatchFileHeader mapFieldSet(FieldSet fieldSet) throws BindException {
		BatchFileHeader result = new BatchFileHeader();
		
		result.setType(fieldSet.readString(HeaderFieldSetMapper.TYPE_COLUMN));
		result.setHeaderCode(this.decimalMapper.map(fieldSet.readString(HeaderFieldSetMapper.HEADER_CODE)));
		
		return result;
	}

}
