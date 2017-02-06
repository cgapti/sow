package com.sow.service.Impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.sow.bo.SOWBO;
import com.sow.dao.Impl.SOWDAOImpl;
import com.sow.exception.SOWException;
import com.sow.model.SOW;
import com.sow.model.JSON.SOWInfo;
import com.sow.service.SOWService;

@Service("sowServiceImpl")
public class SOWServiceImpl implements SOWService {

	
	@Autowired
	private SOWDAOImpl sowDAOImpl;
	
	@Autowired
	private SOWBO sowBO;
	
	/*public String addSOW(SOWInfo addSOW) throws SOWException {
		System.out.println("SowServiceImpl - addSOW method starts");
		System.out.println("SowServiceImpl - addSOW method ends");
		
		return sowBO.saveAddSOW(addSOW);
		
		
	}*/
	
	public String addSOW(SOWInfo addSOW) throws SOWException {
		System.out.println("SowServiceImpl - addSOW method starts");
		System.out.println("SowServiceImpl - addSOW method ends");
		return sowDAOImpl.saveAddSOW(processSOWInfo(addSOW));
		
	}
	
	private SOW processSOWInfo(SOWInfo addSOWInfo) {
		System.out.println("SowServiceImpl - processSOWInfo method starts");
		SOW addSOW=new SOW();
	
		if (null != addSOWInfo) {
			addSOW.setSowNo(addSOWInfo.getSowNo());
			addSOW.setpId(addSOWInfo.getpId());
			addSOW.setContractNo(addSOWInfo.getContractNo());
			addSOW.setPoNo(addSOWInfo.getPoNo());
			addSOW.setOwner(addSOWInfo.getOwner());
			addSOW.setEngmntModel(addSOWInfo.getEngmntModel());
			addSOW.setProjectDtls(addSOWInfo.getProjectDtls());
			addSOW.setResCount(addSOWInfo.getResCount());
			addSOW.setValueMillion(addSOWInfo.getValueMillion());
			addSOW.setSowValueUSD(addSOWInfo.getSowValueUSD());
			addSOW.setSowValueInr(addSOWInfo.getSowValueInr());
			addSOW.setSowValueMyr(addSOWInfo.getSowValueMyr());
			addSOW.setSowValueSgd(addSOWInfo.getSowValueSgd());
			addSOW.setContractCurrency(addSOWInfo.getContractCurrency());
			addSOW.setCurrencyRate(addSOWInfo.getCurrencyRate());
			addSOW.setSowStartDate(addSOWInfo.getSowStartDate());
			addSOW.setSowEndDate(addSOWInfo.getSowEndDate());
			addSOW.setSowStatus(addSOWInfo.getSowStatus());
			addSOW.setLocation(addSOWInfo.getLocation());
			addSOW.setBusinessArea(addSOWInfo.getBusinessArea());
			addSOW.setDeliverySpoc(addSOWInfo.getDeliverySpoc());
			addSOW.setSowRemarks(addSOWInfo.getSowRemarks());
			addSOW.setCustomerToSpoc(addSOWInfo.getCustomerToSpoc());
			addSOW.setCustomerCcSpoc(addSOWInfo.getCustomerCcSpoc());
			addSOW.setDeliveryModel(addSOWInfo.getDeliveryModel());
			addSOW.setCreatedDate(addSOWInfo.getCreatedDate());
			addSOW.setCreatedBy(addSOWInfo.getCreatedBy());
			addSOW.setUpdatedDate(addSOWInfo.getUpdatedDate());
			addSOW.setUpdatedBy(addSOWInfo.getUpdatedBy());
			addSOW.setSowNoSeed(addSOWInfo.getSowNoSeed());
		}
		System.out.println("UserServiceImpl - processUserInfo method starts");
		return addSOW;
	}
	
	public List<SOWInfo> showAllSOW()throws SOWException {
		System.out.println("SowServiceImpl - showAllSOW method starts");
		return sowDAOImpl.fetchSOWData();
		
	}
	
	public List<SOWInfo> showSOW(String SOWno)throws SOWException {
		System.out.println("SowServiceImpl - showSOW method starts");
		return sowDAOImpl.fetchASOWData(SOWno);
		
	}
	
	public BigDecimal currRateCal(String curtype, BigDecimal curvalue) throws SOWException {
		System.out.println("SowServiceImpl - currRateCal method starts");
		return sowDAOImpl.currCalculation(curtype, curvalue);
		
	}
	
	public SOWInfo featchSowRefNo() throws SOWException {
		System.out.println("SowServiceImpl - featchSowRefNo method starts");
		String sowRefNoFmt = null;
		SOWInfo sowInfo = new SOWInfo();
		//SOW 020/SCB/TM
		Integer sowRefNo = sowDAOImpl.featchSowNoSeed();
		if( sowRefNo != null) {
			String sowRefNoStr = sowRefNo.toString();
			if(sowRefNoStr.length() == 1) {
				sowRefNoFmt = "00".concat(sowRefNoStr);
			} else if(sowRefNoStr.length() == 2) {
				sowRefNoFmt = "0".concat(sowRefNoStr);
			} else {
				sowRefNoFmt = sowRefNoStr;
			}
		}
		
		sowRefNoFmt = "SOW ".concat(sowRefNoFmt).concat("/SCB/TM");
		sowInfo.setSowNo(sowRefNoFmt);
		sowInfo.setSowNoSeed(sowRefNo);
		
		System.out.println("*****************sowRefNoFmt***********" + sowRefNoFmt);
		return sowInfo;
		
	}
	
	public List<SOW> showAllSOWForExcel()throws SOWException {
		System.out.println("SowServiceImpl - showAllSOW method starts");
		return sowDAOImpl.fetchSOWDataForExcel();
		
	}
	
	public XSSFWorkbook generateExcel(String[] selectedHeaderList) throws SOWException, IOException {
		// Create blank workbook
	    XSSFWorkbook workbook = new XSSFWorkbook(); 
	    
	    // Create a blank sheet
	    XSSFSheet spreadsheet = workbook.createSheet(" Statement of Work ");
	      
	    // Create row object
	    XSSFRow row;
	      
	    // This data needs to be written (Object[])
	    // Code to generate the header
	    Map<Integer, Object[]> empinfo = new TreeMap < Integer, Object[] >();
	    empinfo.put( 1, (Object[]) selectedHeaderList);
	    
		List<SOW> allsowList = showAllSOWForExcel();
	    
		for (int sow = 0; sow < allsowList.size(); sow++) {
			String[] obj1 = new String[selectedHeaderList.length];
		    for (int selectedHeader = 0; selectedHeader <selectedHeaderList.length; selectedHeader++) {
		    	if (selectedHeaderList[selectedHeader].equalsIgnoreCase("SOW Reference #")) {
		    		obj1[selectedHeader] = allsowList.get(sow).getSowNo();
		    	}	
		    	if (selectedHeaderList[selectedHeader].equalsIgnoreCase("PID")) {
		    		obj1[selectedHeader] = allsowList.get(sow).getpId() == null ? "" : String.valueOf((allsowList.get(sow).getpId()));
		    	}
		    	if (selectedHeaderList[selectedHeader].equalsIgnoreCase("Contract No")) {
		    		obj1[selectedHeader] = allsowList.get(sow).getContractNo();
		    	}
		    	if (selectedHeaderList[selectedHeader].equalsIgnoreCase("PO Ref #")) {
		    		obj1[selectedHeader] = allsowList.get(sow).getPoNo() == null ? "" : String.valueOf(allsowList.get(sow).getPoNo());
		    	}
		    	if (selectedHeaderList[selectedHeader].equalsIgnoreCase("Owner")) {
		    		obj1[selectedHeader] = allsowList.get(sow).getOwner();
		    	}
		    	if (selectedHeaderList[selectedHeader].equalsIgnoreCase("Engagement Model")) {
		    		obj1[selectedHeader] = allsowList.get(sow).getEngmntModel();
		    	}
		    	if (selectedHeaderList[selectedHeader].equalsIgnoreCase("Resource Count")) {
		    		obj1[selectedHeader] = allsowList.get(sow).getResCount() == null ? "" : String.valueOf(allsowList.get(sow).getResCount());
		    	}
		    	if (selectedHeaderList[selectedHeader].equalsIgnoreCase("Project Details")) {
		    		obj1[selectedHeader] = allsowList.get(sow).getProjectDtls();
		    	}
		    	if (selectedHeaderList[selectedHeader].equalsIgnoreCase("Contract Currency (USD, SGD,MYR,INR)")) {
		    		obj1[selectedHeader] = allsowList.get(sow).getContractCurrency();
		    	}
		    	if (selectedHeaderList[selectedHeader].equalsIgnoreCase("SOW Value ( USD)")) {
		    		obj1[selectedHeader] = allsowList.get(sow).getSowValueUSD() == null ? "" : String.valueOf(allsowList.get(sow).getSowValueUSD());
		    	}
		    	if (selectedHeaderList[selectedHeader].equalsIgnoreCase("Value (mn)")) {
		    		obj1[selectedHeader] = allsowList.get(sow).getValueMillion() == null ? "" : String.valueOf(allsowList.get(sow).getValueMillion());
		    	}
		    	if (selectedHeaderList[selectedHeader].equalsIgnoreCase("SOW Value (SGD)")) {
		    		obj1[selectedHeader] = allsowList.get(sow).getSowValueSgd() == null ? "" : String.valueOf(allsowList.get(sow).getSowValueSgd());
		    	}
		    	if (selectedHeaderList[selectedHeader].equalsIgnoreCase("SOW Value (MYR)")) {
		    		obj1[selectedHeader] = allsowList.get(sow).getSowValueMyr() == null ? "" : String.valueOf(allsowList.get(sow).getSowValueMyr());
		    	}
		    	if (selectedHeaderList[selectedHeader].equalsIgnoreCase("SOW Value (INR)")) {
		    		obj1[selectedHeader] = allsowList.get(sow).getSowValueInr() == null ? "" : String.valueOf(allsowList.get(sow).getSowValueInr());
		    	}
		    	if (selectedHeaderList[selectedHeader].equalsIgnoreCase("Start Date")) {
		    		obj1[selectedHeader] = allsowList.get(sow).getSowStartDate() == null ? "" : String.valueOf(allsowList.get(sow).getSowStartDate());
		    	}
		    	if (selectedHeaderList[selectedHeader].equalsIgnoreCase("End Date")) {
		    		obj1[selectedHeader] = allsowList.get(sow).getSowEndDate() == null ? "" : String.valueOf(allsowList.get(sow).getSowEndDate());
		    	}
		    	if (selectedHeaderList[selectedHeader].equalsIgnoreCase("Status of the SOW /PO /Contract")) {
		    		obj1[selectedHeader] = allsowList.get(sow).getSowStatus();
		    	}
		    	if (selectedHeaderList[selectedHeader].equalsIgnoreCase("Location")) {
		    		obj1[selectedHeader] = allsowList.get(sow).getLocation();
		    	}
		    	if (selectedHeaderList[selectedHeader].equalsIgnoreCase("Business Area")) {
		    		obj1[selectedHeader] = allsowList.get(sow).getBusinessArea();
		    	}
		    	if (selectedHeaderList[selectedHeader].equalsIgnoreCase("Delivery SPOC")) {
		    		obj1[selectedHeader] = allsowList.get(sow).getDeliverySpoc();
		    	}
		    	if (selectedHeaderList[selectedHeader].equalsIgnoreCase("Customer TO SPOC")) {
		    		obj1[selectedHeader] = allsowList.get(sow).getCustomerToSpoc();
		    	}
		    	if (selectedHeaderList[selectedHeader].equalsIgnoreCase("Customer CC SPOC")) {
		    		obj1[selectedHeader] = allsowList.get(sow).getCustomerCcSpoc();
		    	}
		    	if (selectedHeaderList[selectedHeader].equalsIgnoreCase("Delivery Model(Staff Aug)")) {
		    		obj1[selectedHeader] = allsowList.get(sow).getDeliveryModel();
		    	}
		    	if (selectedHeaderList[selectedHeader].equalsIgnoreCase("Remarks")) {
		    		obj1[selectedHeader] = allsowList.get(sow).getSowRemarks();
		    	}
		    }
		    empinfo.put(sow+2, (Object[]) obj1);
		}
	    	 
		//Iterate over data and write to sheet
		Set < Integer > keyid = empinfo.keySet();
		int rowid = 0;
		for (int key : keyid)
		{
			row = spreadsheet.createRow(rowid++);
			Object [] objectArr = empinfo.get(key);
			int cellid = 1;
			for (Object obj : objectArr)
			{
				Cell cell = row.createCell(cellid++);
				cell.setCellValue((String)obj);
			}
		}
	      
	    // Code to set the column width
		for (int i=1; i <= selectedHeaderList.length; i++) {
			spreadsheet.setColumnWidth(i, spreadsheet.getColumnWidth(i) + 7500);
		}
	      
		// Code to set the Header Bold
	    CellStyle style = workbook.createCellStyle();//Create style
	    Font font = workbook.createFont();//Create font
	    font.setBoldweight(Font.BOLDWEIGHT_BOLD);//Make font bold
	    style.setFont(font);//set it to bold

	    for (int i = 1; i <  spreadsheet.getRow(0).getLastCellNum(); i++) {//For each cell in the row 
	    	spreadsheet.getRow(0).getCell(i).setCellStyle(style);//Set the style
	    }
	      
	    //Write the workbook in file system
	    FileOutputStream out = new FileOutputStream(new File("//10.30.0.101//Bitlocker//SOW Application//SOW//SOW_ORDER_"+ new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) +".xlsx"));
	    workbook.write(out);
	    out.close();
	    return workbook;
	}
	
}
