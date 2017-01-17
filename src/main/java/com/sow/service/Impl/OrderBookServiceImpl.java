package com.sow.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sow.dao.Impl.OrderBookDAOImpl;
import com.sow.exception.SOWException;
import com.sow.model.OrderBook;
import com.sow.model.JSON.OrderBookInfo;
import com.sow.model.JSON.SOWInfo;
import com.sow.model.JSON.SowDetailsInfo;
import com.sow.service.OrderBookService;

@Service("orderBookServiceImpl")
public class OrderBookServiceImpl implements OrderBookService {

	
	@Autowired
	private OrderBookDAOImpl  orderBookDAOImpl;;
	
	
	public String addOrderBook(OrderBookInfo addOrderBook) throws SOWException {
		System.out.println("OrderBookServiceImpl - addOrderBook method starts");
		System.out.println("OrderBookServiceImpl - addOrderBook method ends");
		return orderBookDAOImpl.saveOrderBook(processOrderBookInfo(addOrderBook));
		
	}
	public List<SowDetailsInfo> fetchAllOrderBook()throws SOWException {
		System.out.println("OrderBookServiceImpl - fetchAllOrderBook method starts");
		return orderBookDAOImpl.fetchOrderBookData();
		
	}
	private OrderBook processOrderBookInfo(OrderBookInfo addOrderBook) {
		System.out.println("OrderBookServiceImpl - processOrderBookInfo method starts");
		OrderBook addOB=new OrderBook();
	
		if (null != addOrderBook) {
			addOB.setSowNo(addOrderBook.getSowNo());
			addOB.setFinYr(addOrderBook.getFinYr());
			addOB.setMonth(addOrderBook.getMonth());
			addOB.setPrjTotal(addOrderBook.getPrjTotal());
			addOB.setTechMPrjDesc(addOrderBook.getTechMPrjDesc());
			addOB.setRemarks(addOrderBook.getRemarks());			
			addOB.setCreatedDate(addOrderBook.getCreatedDate());
			addOB.setCreatedBy(addOrderBook.getCreatedBy());
			addOB.setUpdatedDate(addOrderBook.getUpdatedDate());
			addOB.setUpdatedBy(addOrderBook.getUpdatedBy());
		}
		System.out.println("OrderBookServiceImpl - processOrderBookInfo method starts");
		return addOB;
	}

	
}
