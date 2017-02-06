package com.sow.model.JSON;

import java.io.Serializable;
import java.util.Date;

public class InvoiceDetailsInfo implements Serializable {

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
	private Integer valueMillion;
	private Integer sowValueSgd;
	private Integer SowValueMyr;
	private Integer sowValueInr;
	private String contractCurrency;
	private Date sowStartDate;
	private Date sowEndDate;
	private Integer sowMonth;
	private String sowStatus;
	private String location;
	private String businessArea;
	private String deliverySpoc;
	private String sowRemarks;
	private String ccyRate;
	private String customerToSpoc;
	private String customerCcSpoc;
	private String deliveryModel;
	
	private String finYr;
	private String month;
	private String techMPrjDesc;
	private String contractType;
	private Integer prjTotal;
	private Integer ActTotal;
	private String obRemarks;

	private Date createdDate;
	private String createdBy;
	private Date updatedDate;
	private String updatedBy;
	
	
	private Integer invoiceNo;
	private String digital;
	private String invReference;
	private String utlMonth;
	private Date invoiceDate;
	private Integer invoiceAmt;
	private Integer taxAmt;
	private Integer invoiceTotalAmt;
	private Integer paidAmt;
	private Date paidDate;
	private String paymentId;
	private String invoiceStatus;
	private String invoiceRemarks;
	
	private String sowValuetoUSD;
	
	
	public String getSowValuetoUSD() {
		return sowValuetoUSD;
	}
	public void setSowValuetoUSD(String sowValuetoUSD) {
		this.sowValuetoUSD = sowValuetoUSD;
	}
	public String getCcyRate() {
		return ccyRate;
	}
	public void setCcyRate(String ccyRate) {
		this.ccyRate = ccyRate;
	}
	public Integer getSowMonth() {
		return sowMonth;
	}
	public void setSowMonth(Integer sowMonth) {
		this.sowMonth = sowMonth;
	}
	public String getObRemarks() {
		return obRemarks;
	}
	public void setObRemarks(String obRemarks) {
		this.obRemarks = obRemarks;
	}
	public String getInvoiceRemarks() { 
		return invoiceRemarks;
	}
	public void setInvoiceRemarks(String invoiceRemarks) {
		this.invoiceRemarks = invoiceRemarks;
	}
	public String getFinYr() {
		return finYr;
	}
	public void setFinYr(String finYr) {
		this.finYr = finYr;
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
	public Integer getActTotal() {
		return ActTotal;
	}
	public void setActTotal(Integer actTotal) {
		ActTotal = actTotal;
	}
	public Integer getInvoiceNo() {
		return invoiceNo;
	}
	public void setInvoiceNo(Integer invoiceNo) {
		this.invoiceNo = invoiceNo;
	}
	public String getDigital() {
		return digital;
	}
	public void setDigital(String digital) {
		this.digital = digital;
	}
	public String getInvReference() {
		return invReference;
	}
	public void setInvReference(String invReference) {
		this.invReference = invReference;
	}
	public String getUtlMonth() {
		return utlMonth;
	}
	public void setUtlMonth(String utlMonth) {
		this.utlMonth = utlMonth;
	}
	public Date getInvoiceDate() {
		return invoiceDate;
	}
	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}
	public Integer getInvoiceAmt() {
		return invoiceAmt;
	}
	public void setInvoiceAmt(Integer invoiceAmt) {
		this.invoiceAmt = invoiceAmt;
	}
	public Integer getTaxAmt() {
		return taxAmt;
	}
	public void setTaxAmt(Integer taxAmt) {
		this.taxAmt = taxAmt;
	}
	public Integer getInvoiceTotalAmt() {
		return invoiceTotalAmt;
	}
	public void setInvoiceTotalAmt(Integer invoiceTotalAmt) {
		this.invoiceTotalAmt = invoiceTotalAmt;
	}
	public Integer getPaidAmt() {
		return paidAmt;
	}
	public void setPaidAmt(Integer paidAmt) {
		this.paidAmt = paidAmt;
	}
	public Date getPaidDate() {
		return paidDate;
	}
	public void setPaidDate(Date paidDate) {
		this.paidDate = paidDate;
	}
	public String getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}
	public String getInvoiceStatus() {
		return invoiceStatus;
	}
	public void setInvoiceStatus(String invoiceStatus) {
		this.invoiceStatus = invoiceStatus;
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
