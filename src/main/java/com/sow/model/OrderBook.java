package com.sow.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "WORK_ORDER")
public class OrderBook implements Serializable {

	private static final long serialVersionUID = 8704535406621494434L;

	@Id
	@Column(name = "SOW_NO")
	private String sowNo;

	@Column(name = "FIN_YEAR")
	private String finYr;

	@Column(name = "MONTH")
	private String month;
	
	@Column(name = "TECHM_PRJ_DESCR")
	private String techMPrjDesc;
	    
	@Column(name = "CONTRACT_TYPE") 
	private String contractType;
	
	@Column(name = "PRJ_TOTAL") 
	private Integer prjTotal;
	
	@Column(name = "ACT_TOTAL") 
	private Integer ActTotal;
	
	@Column(name = "OB_REMARKS") 
	private String remarks;
	
	@Column(name = "CREATED_DATE")
	private Date createdDate;

	@Column(name = "CREATED_BY")
	private String createdBy;

	@Column(name = "UPDATED_DATE")
	private Date updatedDate;

	@Column(name = "UPDATED_BY")
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

	public void setPrjTotal(Integer prjTotal) {
		this.prjTotal = prjTotal;
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
