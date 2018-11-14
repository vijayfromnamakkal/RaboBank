package com.rabobank.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.rabobank.domain.Record;

/**
 * @author ksvijaynkl
 *
 */
public class ValidateUtil {
	
	
	/**
	 * Method to mark duplicate transcation 
	 * @param transctionrecordList
	 * @return
	 */
	public static List<Record>  validateDuplicateRecords(List<Record> transctionrecordList) {
		
		
		List<Record> validatedList = new ArrayList<Record>();
		
		transctionrecordList.forEach((rec) -> {
			
			if(Collections.frequency(transctionrecordList, rec) > 1 ) {
				rec.setFailureReason("Duplicate Transaction");				
			}else {
				rec.setSuccess(true);				
			}
		});
		
		
		return validatedList;
		
	}

}
