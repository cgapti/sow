package com.sow.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

@Table(name = "SOW_CURRENCY")
public class SOWCurrency implements Serializable {

	private static final long serialVersionUID = 8704535406621494434L;

	@Id
	@Column(name = "CURRENCY")
	private String currency;
	
	@Column(name = "RATE")
	private BigDecimal rate;
	
	public BigDecimal getRate() {
		return rate;
	}

	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}



}
