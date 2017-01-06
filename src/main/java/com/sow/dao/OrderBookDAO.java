package com.sow.dao;

import com.sow.exception.SOWException;
import com.sow.model.OrderBook;

public interface OrderBookDAO {
	
	String saveOrderBook(OrderBook addOrderBook)throws SOWException;
	

}
