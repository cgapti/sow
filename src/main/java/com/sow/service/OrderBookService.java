package com.sow.service;

import java.util.List;

import com.sow.exception.SOWException;
import com.sow.model.JSON.OrderBookInfo;

public interface OrderBookService {

	
	String addOrderBook(OrderBookInfo addOrderBook)throws SOWException;
	
	
}
