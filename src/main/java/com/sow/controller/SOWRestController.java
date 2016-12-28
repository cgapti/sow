package com.sow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
}
