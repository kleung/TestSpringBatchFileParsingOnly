package com.test.SpringBatchTest.mappers;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import com.test.SpringBatchTest.model.BatchFileFooter;

public class FooterFieldSetMapper implements FieldSetMapper<BatchFileFooter> {
	
	public static final String TYPE_CODE = "TYPE";
	
	public static final String CHECKSUM = "checksum";
	
	public FooterFieldSetMapper() {
		super();
	}

	@Override
	public BatchFileFooter mapFieldSet(FieldSet fieldSet) throws BindException {
		BatchFileFooter result = new BatchFileFooter();
		
		result.setType(fieldSet.readString(FooterFieldSetMapper.TYPE_CODE));
		result.setChecksum(fieldSet.readString(FooterFieldSetMapper.CHECKSUM));
		
		return result;
	}

}
