package com.sow.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sow.dao.Impl.OrderBookDAOImpl;
import com.sow.exception.SOWException;
import com.sow.model.OrderBook;
import com.sow.model.OrderBookPK;
import com.sow.model.JSON.OrderBookInfo;
import com.sow.service.OrderBookService;

@Service("orderBookServiceImpl")
public class OrderBookServiceImpl implements OrderBookService {

	
	@Autowired
	private OrderBookDAOImpl  orderBookDAOImpl;;
	
	
	public String addOrderBook(OrderBookInfo addOrderBook) throws SOWException {
		System.out.println("OrderBookServiceImpl - addSOW method starts");
		System.out.println("OrderBookServiceImpl - addSOW method ends");
		return orderBookDAOImpl.saveOrderBook(processOrderBookInfo(addOrderBook));
		
	}
	
	private OrderBook processOrderBookInfo(OrderBookInfo orderBookInfo) {
		System.out.println("OrderBookServiceImpl - processSOWInfo method starts");
		OrderBook addOB=new OrderBook();
		OrderBookPK orderBookPK = new OrderBookPK();
	
		/*if (null != orderBookInfo) {
			orderBookPK.setSowNo(orderBookInfo.getSowNo());
			orderBookPK.setFinYear(orderBookInfo.getFinYear());
			orderBookPK.setMonth(orderBookInfo.getMonth());
			addOB.setOrderBookPK(orderBookPK);
			addOB.setTechmPrjDescr(orderBookInfo.getTechmPrjDescr());
			addOB.setContractType(orderBookInfo.getContractType());
			addOB.setPrjTotal(orderBookInfo.getPrjTotal());
			addOB.setActTotal(orderBookInfo.getActTotal());
			addOB.setRemarks(orderBookInfo.getRemarks());			
			addOB.setCreatedDate(orderBookInfo.getCreatedDate());
			addOB.setCreatedBy(orderBookInfo.getCreatedBy());
			addOB.setUpdatedDate(orderBookInfo.getUpdatedDate());
			addOB.setUpdatedBy(orderBookInfo.getUpdatedBy());
		}*/
		System.out.println("UserServiceImpl - processUserInfo method starts");
		return addOB;
	}

	
}
