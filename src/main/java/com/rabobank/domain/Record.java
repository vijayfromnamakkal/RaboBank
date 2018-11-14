package com.rabobank.domain;

import java.io.Serializable;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * @author ksvijaynkl
 *
 */
public class Record implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2174716452620300382L;

	 @JacksonXmlProperty(localName = "reference", isAttribute = true)
	private long refNum;
	 @JacksonXmlProperty(localName ="accountNumber")
	private String acctNum;
	 @JacksonXmlProperty(localName ="description")
	private String description;
	 @JacksonXmlProperty(localName ="startBalance")
	private double startBal;
	 @JacksonXmlProperty(localName ="endBalance")
	private double endBal;
	 @JacksonXmlProperty(localName ="mutation")
	private double mutation;
	 
	private boolean success;
	private String failureReason;

	
	
	
	/**
	 * @return the refNum
	 */
	public long getRefNum() {
		return refNum;
	}

	/**
	 * @param refNum the refNum to set
	 */
	public void setRefNum(long refNum) {
		this.refNum = refNum;
	}

	/**
	 * @return the acctNum
	 */
	public String getAcctNum() {
		return acctNum;
	}

	/**
	 * @param acctNum the acctNum to set
	 */
	public void setAcctNum(String acctNum) {
		this.acctNum = acctNum;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the startBal
	 */
	public double getStartBal() {
		return startBal;
	}

	/**
	 * @param startBal the startBal to set
	 */
	public void setStartBal(double startBal) {
		this.startBal = startBal;
	}

	/**
	 * @return the endBal
	 */
	public double getEndBal() {
		return endBal;
	}

	/**
	 * @param endBal the endBal to set
	 */
	public void setEndBal(double endBal) {
		this.endBal = endBal;
	}

	/**
	 * @return the mutation
	 */
	public double getMutation() {
		return mutation;
	}

	/**
	 * @param mutation the mutation to set
	 */
	public void setMutation(double mutation) {
		this.mutation = mutation;
	}

	/**
	 * @return the success
	 */
	public boolean isSuccess() {
		return success;
	}

	/**
	 * @param success the success to set
	 */
	public void setSuccess(boolean success) {
		this.success = success;
	}

	/**
	 * @return the failureReason
	 */
	public String getFailureReason() {
		return failureReason;
	}

	/**
	 * @param failureReason the failureReason to set
	 */
	public void setFailureReason(String failureReason) {
		this.failureReason = failureReason;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (refNum ^ (refNum >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Record other = (Record) obj;
		if (refNum != other.refNum)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Record [refNum=" + refNum + ", acctNum=" + acctNum + "]";
	}

	
}
