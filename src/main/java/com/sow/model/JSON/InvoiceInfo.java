package com.sow.model.JSON;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.sow.exception.CustomException;


public class InvoiceInfo implements Serializable {	
	
	private static final long serialVersionUID = -7639326673869275255L;
	
	private String sowNo;
	
	private InvoiceDetailsInfo sowInfo = new InvoiceDetailsInfo();
	private List<InvoiceDetailsInfo> sowDetailsInfoList = new ArrayList<InvoiceDetailsInfo>();
	private CustomException expception = new CustomException(); 
	
	
	public CustomException getExpception() {
		return expception;
	}
	public void setExpception(CustomException expception) {
		this.expception = expception;
	}
	
	public String getSowNo() {
		return sowNo;
	}
	public void setSowNo(String sowNo) {
		this.sowNo = sowNo;
	}
	
	
	public InvoiceDetailsInfo getSowInfo() {
		return sowInfo;
	}
	public void setSowInfo(InvoiceDetailsInfo sowInfo) {
		this.sowInfo = sowInfo;
	}
	public List<InvoiceDetailsInfo> getSowDetailsInfoList() {
		return sowDetailsInfoList;
	}
	public void setSowDetailsInfoList(List<InvoiceDetailsInfo> sowDetailsInfoList) {
		this.sowDetailsInfoList = sowDetailsInfoList;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
