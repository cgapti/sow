package com.sow.service.Impl;

import java.math.BigDecimal;
import java.util.List;

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
			addSOW.setSowStartDate(addSOWInfo.getSowEndDate());
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
	
}
