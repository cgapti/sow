package com.sow.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class OrderBookPK implements Serializable {

	private static final long serialVersionUID = 8704535406621494434L;
	
	@Column(name = "SOW_NO",nullable=false, updatable=false)
	private String sowNo;
	
	@Column(name = "FIN_YEAR",nullable=false, updatable=false)
	private String finYear;
	
	
	@Column(name = "MONTH",nullable=false, updatable=false)
	private String month;


	public String getSowNo() {
		return sowNo;
	}


	public void setSowNo(String sowNo) {
		this.sowNo = sowNo;
	}


	public String getFinYear() {
		return finYear;
	}


	public void setFinYear(String finYear) {
		this.finYear = finYear;
	}


	public String getMonth() {
		return month;
	}


	public void setMonth(String month) {
		this.month = month;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	




}
