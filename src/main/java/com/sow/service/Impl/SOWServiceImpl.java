package com.sow.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sow.dao.Impl.SOWDAOImpl;
import com.sow.exception.SOWException;
import com.sow.model.AddSOW;
import com.sow.model.JSON.AddSOWInfo;
import com.sow.service.SOWService;

@Service("sowServiceImpl")
public class SOWServiceImpl implements SOWService {

	
	@Autowired
	private SOWDAOImpl sowDAOImpl;;
	
	public String addSOW(AddSOWInfo addSOW) throws SOWException {
		System.out.println("SowServiceImpl - addSOW method starts");
		System.out.println("SowServiceImpl - addSOW method ends");
		return sowDAOImpl.saveAddSOW(processSOWInfo(addSOW));
		
	}
	
	private AddSOW processSOWInfo(AddSOWInfo addSOWInfo) {
		System.out.println("SowServiceImpl - processSOWInfo method starts");
		AddSOW addSOW=new AddSOW();
	
		if (null != addSOWInfo) {
			addSOW.setSowNo(addSOWInfo.getSowNo());
			addSOW.setpId(addSOWInfo.getpId());
			addSOW.setContractNo(addSOWInfo.getContractNo());
			addSOW.setPoNo(addSOWInfo.getPoNo());
			addSOW.setOwner(addSOWInfo.getOwner());
			addSOW.setEngmntModel(addSOWInfo.getEngmntModel());
			addSOW.setProjectDtls(addSOWInfo.getProjectDtls());
			addSOW.setResCount(addSOWInfo.getResCount());
			addSOW.setSowValue(addSOWInfo.getSowValue());
			addSOW.setSowCurrency(addSOWInfo.getSowCurrency());
			addSOW.setSowValueInr(addSOWInfo.getSowValueInr());
			addSOW.setSowValueMyr(addSOWInfo.getSowValueMyr());
			addSOW.setSowValueSgd(addSOWInfo.getSowValueSgd());
			addSOW.setContractCurrency(addSOWInfo.getContractCurrency());
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
		}
		System.out.println("UserServiceImpl - processUserInfo method starts");
		return addSOW;
	}
}
