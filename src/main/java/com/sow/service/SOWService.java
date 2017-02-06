package com.sow.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.sow.exception.SOWException;
import com.sow.model.JSON.SOWInfo;

public interface SOWService {

	String addSOW(SOWInfo addSOW)throws SOWException;
	
	List<SOWInfo> showAllSOW()throws SOWException;
	
	List<SOWInfo> showSOW(String SOWno)throws SOWException;
	
	BigDecimal currRateCal(String curtype, BigDecimal curvalue)throws SOWException;
	
	SOWInfo featchSowRefNo()throws SOWException;
	
	XSSFWorkbook generateExcel(String[] selectedHeaderList) throws FileNotFoundException, SOWException, IOException;

	//Integer getSowNoSeed();
}
