package com.sow.service;

import com.sow.exception.SOWException;
import com.sow.model.JSON.SOWInfo;

public interface SOWService {

	String addSOW(SOWInfo addSOW)throws SOWException;
}
