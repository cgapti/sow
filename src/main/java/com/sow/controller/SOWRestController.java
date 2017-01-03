package com.sow.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sow.exception.SOWException;
import com.sow.model.JSON.SOWInfo;
import com.sow.service.SOWService;

@RestController
public class SOWRestController {

	
	@Autowired     
	private SOWService sowServiceImpl;
	
	@CrossOrigin(origins = "*", maxAge = 3600)
	@RequestMapping(value = "/addSOW", method = RequestMethod.POST, headers = "Accept=application/json")	
	public ResponseEntity<String> addSOW(@RequestBody SOWInfo addSOW)
			throws SOWException {
		System.out
				.println("Add SOWController - Add SOW method starts");
		String flag = "failed";
		if (null != addSOW) {
			flag = sowServiceImpl.addSOW(addSOW);
		}
		System.out
				.println("Add SOWController - Add SOW method ends");
		return new ResponseEntity<String>(flag, HttpStatus.OK);
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
	
}
