package com.sow.dao;

import com.sow.exception.SOWException;
import com.sow.model.SOW;

public interface SOWDAO {
	
	String saveAddSOW(SOW addSOW)throws SOWException;
	

}
