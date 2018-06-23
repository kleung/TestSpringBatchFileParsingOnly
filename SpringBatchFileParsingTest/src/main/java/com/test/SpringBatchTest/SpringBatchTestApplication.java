package com.test.SpringBatchTest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

import com.test.SpringBatchTest.model.AbstractInterfaceFileContent;

@SpringBootApplication
@ImportResource(value= {"classpath:batch/batch-context.xml"})
public class SpringBatchTestApplication implements CommandLineRunner {

	@Autowired
	protected FlatFileItemReader fileReader;
	
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBatchTestApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<AbstractInterfaceFileContent> contents = new ArrayList<AbstractInterfaceFileContent>();
		
		try {
			AbstractInterfaceFileContent content = null;
			this.fileReader.open(new ExecutionContext());
			
			while((content = (AbstractInterfaceFileContent)this.fileReader.read()) != null) {
				contents.add(content);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				this.fileReader.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		System.out.println(contents);
	}
}
