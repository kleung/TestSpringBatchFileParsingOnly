package com.test.SpringBatchTest.mappers;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import com.test.SpringBatchTest.model.BatchRecord;

public class BatchRecordFieldSetMapper implements FieldSetMapper<BatchRecord> {
	
	public static final String TYPE_CODE = "RECORD";
	
	public static final String VALUE = "value";
	
	public static final String PERSON = "person";
	
	public static final String PURPOSE = "purpose";
	
	protected BigDecimalMapper valueMapper;
	
	public BatchRecordFieldSetMapper() {
		super();
	}
	
	public void setValueMapper(BigDecimalMapper valueMapper) {
		this.valueMapper = valueMapper;
	}

	@Override
	public BatchRecord mapFieldSet(FieldSet fieldSet) throws BindException {
		BatchRecord result = new BatchRecord();
		
		result.setType(BatchRecordFieldSetMapper.TYPE_CODE);
		result.setValue(this.valueMapper.map(fieldSet.readString(BatchRecordFieldSetMapper.VALUE)));
		result.setPerson(fieldSet.readString(BatchRecordFieldSetMapper.PERSON));
		result.setPurpose(fieldSet.readString(BatchRecordFieldSetMapper.PURPOSE));
		
		
		return result;
	}

}
