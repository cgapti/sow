package com.sow.dao;

import java.util.List;

import com.sow.exception.SOWException;
import com.sow.model.OrderBook;
import com.sow.model.JSON.OrderBookInfo;
import com.sow.model.JSON.SOWInfo;
import com.sow.model.JSON.SowDetailsInfo;

public interface OrderBookDAO {
	
	String saveOrderBook(OrderBook addOrderBook)throws SOWException;
	
	List<SowDetailsInfo> fetchOrderBookData()throws SOWException;
}
