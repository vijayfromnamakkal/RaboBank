package com.rabobank.domain;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import java.util.Arrays;

/**
 * @author ksvijaynkl
 *
 */
@JacksonXmlRootElement(localName = "records")
public class Records {

	@JacksonXmlElementWrapper(localName = "record", useWrapping = false)
	private Record[] record;

	/**
	 * @TODO
	 */
	public Records() {

	}

	/**
	 * @param record
	 */
	public Records(Record[] record) {
		this.record = record;

	}

	/**
	 * @return
	 */
	public Record[] getRecord() {
		return record;
	}

	/**
	 * @param record
	 */
	public void setRecord(Record[] record) {
		this.record = record;
	}

	@Override
	public String toString() {
		return "Records{" + "records=" + Arrays.toString(record) + '}';
	}

}
