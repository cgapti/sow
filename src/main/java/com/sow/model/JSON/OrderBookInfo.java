package com.sow.model.JSON;

import java.io.Serializable;
import java.util.Date;

public class OrderBookInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7639326673869275255L;
	
	private String sowNo;
	private String finYr;
	private String month;
	private String techMPrjDesc;
	private String contractType;
	private Integer prjTotal;
	private Integer ActTotal;
	private String remarks;
	private Date createdDate;
	private String createdBy;
	private Date updatedDate;
	private String updatedBy;
	
	public String getSowNo() {
		return sowNo;
	}
	public void setSowNo(String sowNo) {
		this.sowNo = sowNo;
	}
	
	public String getFinYr() {
		return finYr;
	}
	public void setFinYr(String finYr) {
		this.finYr = finYr;
	}
	public Integer getActTotal() {
		return ActTotal;
	}
	public void setActTotal(Integer actTotal) {
		ActTotal = actTotal;
	}
	public void setPrjTotal(Integer prjTotal) {
		this.prjTotal = prjTotal;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getTechMPrjDesc() {
		return techMPrjDesc;
	}
	public void setTechMPrjDesc(String techMPrjDesc) {
		this.techMPrjDesc = techMPrjDesc;
	}
	public String getContractType() {
		return contractType;
	}
	public void setContractType(String contractType) {
		this.contractType = contractType;
	}
	
	public Integer getPrjTotal() {
		return prjTotal;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	
	
	
	
	
	
	
		
	
}
