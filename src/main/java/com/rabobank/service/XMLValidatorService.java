package com.rabobank.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.rabobank.domain.Record;
import com.rabobank.domain.Records;
import com.rabobank.util.ValidateUtil;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


/**
 * @author ksvijaynkl
 *
 */
@Service
public class XMLValidatorService {
	
	/**
	 * Merhod to parse and validate xml files
	 * @param file
	 * @return
	 * @throws IOException
	 */
	public List<Record> validateCSVFile(MultipartFile file) throws IOException {
		
		ObjectMapper objectMapper = new XmlMapper();
		Records records = objectMapper.readValue(StringUtils.toEncodedString(file.getBytes(), StandardCharsets.UTF_8), Records.class);
		
		List<Record> transctionrecordList = Arrays.asList(records.getRecord());
		ValidateUtil.validateDuplicateRecords(transctionrecordList);
		
		return transctionrecordList;
		
		
	}

}
