package com.sow.model.JSON;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.sow.model.Invoice;


public class InvoiceInfo implements Serializable {	
	
	private static final long serialVersionUID = -7639326673869275255L;
	
	private String sowNo;
	
	private SowDetailsInfo sowInfo = new SowDetailsInfo();
	private List<SowDetailsInfo> sowDetailsInfoList = new ArrayList<SowDetailsInfo>();
	 
	public SowDetailsInfo getSowInfo() {
		return sowInfo;
	}
	public void setSowInfo(SowDetailsInfo sowInfo) {
		this.sowInfo = sowInfo;
	}
	public String getSowNo() {
		return sowNo;
	}
	public void setSowNo(String sowNo) {
		this.sowNo = sowNo;
	}
	
	public List<SowDetailsInfo> getSowDetailsInfoList() {
		return sowDetailsInfoList;
	}
	public void setSowDetailsInfoList(List<SowDetailsInfo> sowDetailsInfoList) {
		this.sowDetailsInfoList = sowDetailsInfoList;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
