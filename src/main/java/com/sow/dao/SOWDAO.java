package com.sow.dao;

import java.math.BigDecimal;
import java.util.List;

import com.sow.exception.SOWException;
import com.sow.model.SOW;
import com.sow.model.JSON.SOWInfo;

public interface SOWDAO {
	
	String saveAddSOW(SOW addSOW)throws SOWException;
	
	List<SOWInfo> fetchSOWData()throws SOWException;
	
	List<SOWInfo> fetchASOWData(String SOWno)throws SOWException;
	
	BigDecimal currCalculation(String curtype, BigDecimal curvalue)throws SOWException;
	

}
