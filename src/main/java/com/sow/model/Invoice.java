package com.sow.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "INVOICE")
public class Invoice implements Serializable {

	private static final long serialVersionUID = 8704535406621494434L;

	@Id
	@Column(name = "INVOICE_NO")
	private Integer invoiceNo;
	
	@Column(name = "SOW_NO")
	private String sowNo;
	
	@Column(name = "UTL_MONTH")
	private String utlMonth;
	
	@Column(name = "INVOICE_DATE")
	private Date invoiceDate;
	
	@Column(name = "INVOICE_AMT")
	private Integer invoiceAmt;
	
	@Column(name = "TAX_AMT")
	private Integer taxAmt;
	
	@Column(name = "INVOICE_TOTAL_AMT")
	private Integer invoiceTotalAmt;
	
	@Column(name = "INV_CUR")
	private Integer invCur;
	
	@Column(name = "PAID_AMT")
	private Integer paidAmt;
	
	@Column(name = "PAID_DATE")
	private Date paidDate;
	
	@Column(name = "PAYMENT_ID")
	private Integer paymentId;
	
	@Column(name = "INVOICE_STATUS")
	private Integer invoiceStatus;
	
	@Column(name = "REMARKS")
	private Integer remarks;

	@Column(name = "CREATED_DATE")
	private Date createdDate;

	@Column(name = "CREATED_BY")
	private String createdBy;

	@Column(name = "UPDATED_DATE")
	private Date updatedDate;

	@Column(name = "UPDATED_BY")
	private String updatedBy;

	public Integer getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(Integer invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public String getSowNo() {
		return sowNo;
	}

	public void setSowNo(String sowNo) {
		this.sowNo = sowNo;
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

	public Integer getInvCur() {
		return invCur;
	}

	public void setInvCur(Integer invCur) {
		this.invCur = invCur;
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

	public Integer getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Integer paymentId) {
		this.paymentId = paymentId;
	}

	public Integer getInvoiceStatus() {
		return invoiceStatus;
	}

	public void setInvoiceStatus(Integer invoiceStatus) {
		this.invoiceStatus = invoiceStatus;
	}

	public Integer getRemarks() {
		return remarks;
	}

	public void setRemarks(Integer remarks) {
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
