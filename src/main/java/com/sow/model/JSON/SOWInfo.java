package com.sow.model.JSON;

import java.io.Serializable;
import java.util.Date;

public class SOWInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7639326673869275255L;
	
	private String sowNo;
	private Integer pId;
	private String contractNo;
	private Integer poNo;
	private String owner;
	private String engmntModel;
	private String projectDtls;
	private Integer resCount;
	private Integer sowValue;
	private String sowCurrency;
	private Integer sowValueSgd;
	private Integer SowValueMyr;
	private Integer sowValueInr;
	private String contractCurrency;
	private Date sowStartDate;
	private Date sowEndDate;
	private String sowStatus;
	private String location;
	private String businessArea;
	private String deliverySpoc;
	private String sowRemarks;
	private String customerToSpoc;
	private String customerCcSpoc;
	private String deliveryModel;
	private Date createdDate;
	private String createdBy;
	private Date updatedDate;
	private String updatedBy;
	
	
	public Integer getpId() {
		return pId;
	}
	public void setpId(Integer pId) {
		this.pId = pId;
	}
	public String getContractNo() {
		return contractNo;
	}
	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}
	public Integer getPoNo() {
		return poNo;
	}
	public void setPoNo(Integer poNo) {
		this.poNo = poNo;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getEngmntModel() {
		return engmntModel;
	}
	public void setEngmntModel(String engmntModel) {
		this.engmntModel = engmntModel;
	}
	public String getProjectDtls() {
		return projectDtls;
	}
	public void setProjectDtls(String projectDtls) {
		this.projectDtls = projectDtls;
	}
	public Integer getResCount() {
		return resCount;
	}
	public void setResCount(Integer resCount) {
		this.resCount = resCount;
	}
	public Integer getSowValue() {
		return sowValue;
	}
	public void setSowValue(Integer sowValue) {
		this.sowValue = sowValue;
	}
	public String getSowCurrency() {
		return sowCurrency;
	}
	public void setSowCurrency(String sowCurrency) {
		this.sowCurrency = sowCurrency;
	}
	public Integer getSowValueSgd() {
		return sowValueSgd;
	}
	public void setSowValueSgd(Integer sowValueSgd) {
		this.sowValueSgd = sowValueSgd;
	}
	public Integer getSowValueMyr() {
		return SowValueMyr;
	}
	public void setSowValueMyr(Integer sowValueMyr) {
		SowValueMyr = sowValueMyr;
	}
	public Integer getSowValueInr() {
		return sowValueInr;
	}
	public void setSowValueInr(Integer sowValueInr) {
		this.sowValueInr = sowValueInr;
	}
	public String getContractCurrency() {
		return contractCurrency;
	}
	public void setContractCurrency(String contractCurrency) {
		this.contractCurrency = contractCurrency;
	}
	public Date getSowStartDate() {
		return sowStartDate;
	}
	public void setSowStartDate(Date sowStartDate) {
		this.sowStartDate = sowStartDate;
	}
	public Date getSowEndDate() {
		return sowEndDate;
	}
	public void setSowEndDate(Date sowEndDate) {
		this.sowEndDate = sowEndDate;
	}
	public String getSowStatus() {
		return sowStatus;
	}
	public void setSowStatus(String sowStatus) {
		this.sowStatus = sowStatus;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getBusinessArea() {
		return businessArea;
	}
	public void setBusinessArea(String businessArea) {
		this.businessArea = businessArea;
	}
	public String getDeliverySpoc() {
		return deliverySpoc;
	}
	public void setDeliverySpoc(String deliverySpoc) {
		this.deliverySpoc = deliverySpoc;
	}
	public String getSowRemarks() {
		return sowRemarks;
	}
	public void setSowRemarks(String sowRemarks) {
		this.sowRemarks = sowRemarks;
	}
	public String getCustomerToSpoc() {
		return customerToSpoc;
	}
	public void setCustomerToSpoc(String customerToSpoc) {
		this.customerToSpoc = customerToSpoc;
	}
	public String getCustomerCcSpoc() {
		return customerCcSpoc;
	}
	public void setCustomerCcSpoc(String customerCcSpoc) {
		this.customerCcSpoc = customerCcSpoc;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getDeliveryModel() {
		return deliveryModel;
	}
	public void setDeliveryModel(String deliveryModel) {
		this.deliveryModel = deliveryModel;
	}
	/**
	 * @return the sowNo
	 */
	public String getSowNo() {
		return sowNo;
	}
	/**
	 * @param sowNo the sowNo to set
	 */
	public void setSowNo(String sowNo) {
		this.sowNo = sowNo;
	}
		
	
}
