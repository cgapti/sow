package com.sow.service;

import com.sow.exception.SOWException;
import com.sow.model.JSON.AddSOWInfo;

public interface SOWService {

	String addSOW(AddSOWInfo addSOW)throws SOWException;
}
