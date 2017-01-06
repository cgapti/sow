package com.sow.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sow.exception.SOWException;
import com.sow.model.Invoice;
import com.sow.model.JSON.SOWInfo;
import com.sow.service.InvoiceService;
import com.sow.service.SOWService;

@RestController
public class SOWRestController {

	
	@Autowired     
	private SOWService sowServiceImpl;
	
	@Autowired     
	private InvoiceService invoiceService;
	
	@CrossOrigin(origins = "*", maxAge = 3600)
	@RequestMapping(value = "/addSOW", method = RequestMethod.POST, headers = "Accept=application/json")	
	public ResponseEntity<String> addSOW(@RequestBody SOWInfo sowInfo)
			throws SOWException {
		System.out.println("Add SOWController - Add SOW method starts");
		String response = "";
		HttpStatus responseStatus = HttpStatus.EXPECTATION_FAILED;
		
		if (sowInfo != null) {
			/*response = validateSowInfoObject(sowInfo);
			System.out.println("Add SOWController - Add SOW method starts"+response);
			if(response == null) {
				response = sowServiceImpl.addSOW(sowInfo);
				responseStatus = HttpStatus.OK;
			}*/
			response = sowServiceImpl.addSOW(sowInfo);
			responseStatus = HttpStatus.OK;
		}
		System.out
				.println("Add SOWController - Add SOW method ends");
		return new ResponseEntity<String>(response, responseStatus);
	}
	
	
	private String validateSowInfoObject(SOWInfo sowInfo) {
		System.out.println("Inside SOWController - Add validateSowInfoObject starts");
		
		StringBuffer errorMessage = new StringBuffer();
		
		if(sowInfo != null) {		
			String owner = sowInfo.getOwner();
			String contactNo = sowInfo.getContractNo();
			Integer resCount = sowInfo.getResCount();
			Integer valueMillons = sowInfo.getValueMillion();
			String engmntModel = sowInfo.getEngmntModel();
			String projectDtls = sowInfo.getProjectDtls();
			
			
			checkError(errorMessage, owner, "Owner filed should not be empty");
			checkError(errorMessage, contactNo, "Contact No filed should not be empty");
			checkError(errorMessage, resCount, "resCount filed should not be empty");
			checkError(errorMessage, valueMillons, "valueMillons filed should not be empty");
			checkError(errorMessage, engmntModel, "Engmnt Model filed should not be empty");
			checkError(errorMessage, projectDtls, "projectDtls filed should not be empty");
		}
		return errorMessage.toString();
	}


	private String checkError(StringBuffer errorMessageSB, String field, String errorMsg) {
		System.out.println("Inside SOWController - Add String checkError starts");
		
		if(!StringUtils.isEmpty(field) && !StringUtils.isEmpty(errorMsg)) {
			if(!StringUtils.isEmpty(errorMessageSB))
				errorMessageSB.append("\n");
			
			errorMessageSB.append(errorMsg);
		}
		return errorMessageSB.toString();
	}
	
	private String checkError(StringBuffer errorMessageSB, Integer field, String errorMsg) {
		System.out.println("Inside SOWController - Add checkError number check starts");
		if(field==0 && field<=0) {
			if(!StringUtils.isEmpty(errorMessageSB))
				errorMessageSB.append("\n");
			
			errorMessageSB.append(errorMsg);
		}
		return errorMessageSB.toString();
	}


	@CrossOrigin(origins = "*", maxAge = 3600)
	@RequestMapping(value = "/fetchAllSOW", method = RequestMethod.GET, headers = "Accept=application/json")	
	public ResponseEntity<List<SOWInfo>> fetchAllSOW()
			throws SOWException {
		System.out
				.println("Fetch SOWController - fetchAllSOW method starts");
		List<SOWInfo> allsowList = new ArrayList<SOWInfo>();
		allsowList = sowServiceImpl.showAllSOW();
		System.out
				.println("Fetch SOWController - fetchAllSOW method ends");
		return new ResponseEntity<List<SOWInfo>>(allsowList, HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "*", maxAge = 3600)
	@RequestMapping(value = "/fetchSOW", params = {"data"}, method = RequestMethod.GET, headers = "Accept=application/json")	
	public ResponseEntity<List<SOWInfo>> fetchSOW(@RequestParam(value = "data") String data)
			throws SOWException {
		System.out
				.println("Fetch Single SOWController - fetchSOW method starts");
		List<SOWInfo> sowList = new ArrayList<SOWInfo>();
		sowList = sowServiceImpl.showSOW(data);
		System.out
				.println("Fetch Single SOWController - fetchSOW method ends");
		return new ResponseEntity<List<SOWInfo>>(sowList, HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "*", maxAge = 3600)
	@RequestMapping(value = "/currCal", method = RequestMethod.GET, headers = "Accept=application/json")	
	public ResponseEntity<BigDecimal> currCal(@RequestParam(value = "curtype") String curtype, @RequestParam(value = "curvalue") BigDecimal curvalue)
			throws SOWException {
		System.out
				.println("Currency Calculation SOWController - currCal method starts");
		BigDecimal totalvalue = null;
		totalvalue = sowServiceImpl.currRateCal(curtype,curvalue);
		System.out
				.println("Currency Calculation SOWController - currCal method ends");
		return new ResponseEntity<BigDecimal>(totalvalue, HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "*", maxAge = 3600)
	@RequestMapping(value = "/viewInvoice", method = RequestMethod.POST, headers = "Accept=application/json")	
	public ResponseEntity<List<Invoice>> viewInvoice(@RequestBody Invoice invoice)
			throws SOWException {
		System.out
				.println("View Invocie Controller - View Invoice method starts");
		List<Invoice> invoices = new ArrayList<Invoice>();
		
		if(invoice != null && !StringUtils.isEmpty(invoice.getSowNo()))
			invoices = invoiceService.viewInvoice(invoice);
		
		System.out
				.println("View Invocie Controller - View Invoice method ends");
		
		return ResponseEntity.ok(invoices);
	}
	
}
