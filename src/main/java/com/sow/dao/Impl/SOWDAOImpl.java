package com.sow.dao.Impl;

import org.springframework.stereotype.Repository;

import com.sow.dao.AbstractDao;
import com.sow.dao.SOWDAO;
import com.sow.exception.SOWException;
import com.sow.model.AddSOW;

@Repository("/sowDAOImpl")
public class SOWDAOImpl extends AbstractDao<Integer, AddSOW> implements
		SOWDAO {
	
	public String saveAddSOW(AddSOW addSOW)throws SOWException{
		System.out.println("SOWDAOImpl - saveAddSOW method starts");
		saveOrUpdate(addSOW);
		System.out.println("SOWDAOImpl - saveAddSOW method starts");
		return "success";
	}

	
}
