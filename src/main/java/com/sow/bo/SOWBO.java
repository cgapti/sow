package com.sow.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sow.dao.Impl.SOWDAOImpl;
import com.sow.exception.SOWException;
import com.sow.model.SOW;
import com.sow.model.JSON.SOWInfo;

@Service
public class SOWBO  {
	
	@Autowired
	private SOWDAOImpl sowDAOImpl;
	
	public String saveAddSOW(SOWInfo addSOW)throws SOWException{
		//SOW sowNoSeed = sowDAOImpl.featchSowNoSeed();
		
		//System.out.println("*8***************************" + sowNoSeed);
		return null;
		//return sowDAOImpl.saveAddSOW(processSOWInfo(addSOW));
	
	}
	

}
