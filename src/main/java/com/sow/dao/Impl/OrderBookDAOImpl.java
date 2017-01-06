package com.sow.dao.Impl;

import org.springframework.stereotype.Repository;

import com.sow.dao.AbstractDao;
import com.sow.dao.OrderBookDAO;
import com.sow.exception.SOWException;
import com.sow.model.OrderBook;

@Repository("/orderBookDAOImpl")
public class OrderBookDAOImpl extends AbstractDao<Integer, OrderBook> implements
OrderBookDAO {
	
	public String saveOrderBook(OrderBook orderBook)throws SOWException{
		System.out.println("OrderBookDAOImpl - saveOrderBook method starts");
		saveOrUpdate(orderBook);
		System.out.println("OrderBookDAOImpl - saveOrderBook method starts");
		return "success";
	}
	
	
}

