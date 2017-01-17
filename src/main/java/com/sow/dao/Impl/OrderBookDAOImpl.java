package com.sow.dao.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.sow.dao.AbstractDao;
import com.sow.dao.OrderBookDAO;
import com.sow.exception.SOWException;
import com.sow.model.OrderBook;
import com.sow.model.JSON.OrderBookInfo;
import com.sow.model.JSON.SOWInfo;
import com.sow.model.JSON.SowDetailsInfo;

@Repository("/orderBookDAOImpl")
public class OrderBookDAOImpl extends AbstractDao<Integer, OrderBook> implements
OrderBookDAO {
	
	public String saveOrderBook(OrderBook addOrderBook)throws SOWException{
		System.out.println("OrderBookDAOImpl - saveOrderBook method starts");
		saveOB(addOrderBook);
		System.out.println("OrderBookDAOImpl - saveOrderBook method starts");
		return "success";
	}
	
	public List<SowDetailsInfo> fetchOrderBookData()throws SOWException{
		System.out.println("OrderBookDAOImpl - fetchOrderBookData method starts");
		List<SowDetailsInfo> allOB= new ArrayList<SowDetailsInfo>();
		if (allOB == null || allOB.isEmpty()) {
			allOB = createListEntityCriteriaOB();
		}
		System.out.println("OrderBookDAOImpl - fetchOrderBookData method ends");
		return allOB;
	}
	
}

