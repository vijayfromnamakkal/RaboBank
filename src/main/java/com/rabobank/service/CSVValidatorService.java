package com.rabobank.service;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.rabobank.domain.Record;
import com.rabobank.util.CsvUtil;
import com.rabobank.util.ValidateUtil;

/**
 * @author ksvijaynkl
 *
 */
@Service
public class CSVValidatorService {

	Logger log = LoggerFactory.getLogger(this.getClass().getName());

	/** 
	 * Method for parsing and validating csv files
	 * @param file
	 * @return
	 * @throws IOException
	 */
	public List<Record> validateCSVFile(MultipartFile file) throws IOException {

		List<Record> transctionrecordList = null;

		transctionrecordList = CsvUtil.parseCSVToBeanList(file.getInputStream());
		ValidateUtil.validateDuplicateRecords(transctionrecordList);
		
		return transctionrecordList;

	}

}
