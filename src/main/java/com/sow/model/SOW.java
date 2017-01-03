package com.sow.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

@Table(name = "SOW_MS")
public class SOW implements Serializable {

	private static final long serialVersionUID = 8704535406621494434L;

	@Id
	@Column(name = "SOW_NO")
	private String sowNo;

	@Column(name = "PID")
	private Integer pId;

	@Column(name = "CONTRACT_NO")
	private String contractNo;

	@Column(name = "PO_NO")
	private Integer poNo;

	@Column(name = "OWNER")
	private String owner;

	@Column(name = "ENGMNT_MODEL")
	private String engmntModel;

	@Column(name = "PROJECT_DTLS")
	private String projectDtls;

	@Column(name = "RES_COUNT")
	private Integer resCount;

	@Column(name = "VALUE_MILLION")
	private Integer valueMillion;

	@Column(name = "SOW_VALUE_SGD")
	private Integer sowValueSgd;

	@Column(name = "SOW_VALUE_MYR")
	private Integer SowValueMyr;

	@Column(name = "SOW_VALUE_INR")
	private Integer sowValueInr;

	@Column(name = "CONTRACT_CURRENCY")
	private String contractCurrency;

	@Column(name = "SOW_START_DATE")
	private Date sowStartDate;

	@Column(name = "SOW_END_DATE")
	private Date sowEndDate;

	@Column(name = "SOW_STATUS")
	private String sowStatus;

	@Column(name = "LOCATION")
	private String location;

	@Column(name = "BUSINESS_AREA")
	private String businessArea;

	@Column(name = "DELIVERY_SPOC")
	private String deliverySpoc;

	@Column(name = "SOW_REMARKS")
	private String sowRemarks;

	@Column(name = "CUSTOMER_TO_SPOC")
	private String customerToSpoc;

	@Column(name = "CUSTOMER_CC_SPOC")
	private String customerCcSpoc;

	@Column(name = "DELIVERY_MODEL")
	private String deliveryModel;

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

	public Integer getValueMillion() {
		return valueMillion;
	}

	public void setValueMillion(Integer valueMillion) {
		this.valueMillion = valueMillion;
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

}
