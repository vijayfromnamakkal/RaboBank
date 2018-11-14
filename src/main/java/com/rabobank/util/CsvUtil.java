package com.rabobank.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rabobank.domain.Record;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.bean.CsvToBean;
import au.com.bytecode.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;


/**
 * @author ksvijaynkl
 *
 */
public class CsvUtil {

	/** 
	 * Utility class for aprsing csf files and map to domain objects
	 * @param ioStream
	 * @return
	 * @throws IOException
	 */
	public static List<Record> parseCSVToBeanList(InputStream ioStream) throws IOException {
		
		

		HeaderColumnNameTranslateMappingStrategy<Record> beanStrategy = new HeaderColumnNameTranslateMappingStrategy<Record>();
		beanStrategy.setType(Record.class);

		Map<String, String> columnMapping = new HashMap<String, String>();
		columnMapping.put("Reference", "refNum");
		columnMapping.put("AccountNumber", "acctNum");
		columnMapping.put("Description", "description");
		columnMapping.put("Start Balance", "startBal");
		columnMapping.put("End Balance", "endBal");
		columnMapping.put("Mutation", "mutation");

		beanStrategy.setColumnMapping(columnMapping);

		CsvToBean<Record> csvToBean = new CsvToBean<Record>();
		CSVReader reader = new CSVReader(new InputStreamReader(ioStream));
		List<Record> transctionrecordList = csvToBean.parse(beanStrategy, reader);
		
		return transctionrecordList;
		
	}
	
	
	

}
