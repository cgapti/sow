package com.sow.service;

import java.util.List;

import com.sow.exception.SOWException;
import com.sow.model.JSON.OrderBookInfo;
import com.sow.model.JSON.SOWInfo;
import com.sow.model.JSON.SowDetailsInfo;

public interface OrderBookService {

	
	String addOrderBook(OrderBookInfo addOrderBook)throws SOWException;

	List<SowDetailsInfo> fetchAllOrderBook()throws SOWException;
	
}
