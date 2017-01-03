package com.sow.model.JSON;

import java.io.Serializable;
import java.math.BigDecimal;

public class SOWCurrencyInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7639326673869275255L;
	
	private String currency;
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
