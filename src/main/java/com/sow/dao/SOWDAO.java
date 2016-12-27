package com.sow.dao;

import com.sow.exception.SOWException;
import com.sow.model.AddSOW;

public interface SOWDAO {
	
	String saveAddSOW(AddSOW addSOW)throws SOWException;
	

}
