package com.sow.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sow.dao.Impl.InvoiceDAOImpl;
import com.sow.exception.SOWException;
import com.sow.model.Invoice;
import com.sow.service.InvoiceService;

@Service("invoiceServiceImpl")
public class InvoiceServiceImpl implements InvoiceService {
	
	@Autowired
	private InvoiceDAOImpl invoiceDAOImpl;;
	
	public String viewInvoice(Invoice invoice) throws SOWException {
		System.out.println("SowServiceImpl - addSOW method starts");
		System.out.println("SowServiceImpl - addSOW method ends");
		return invoiceDAOImpl.viewInvoice(invoice);
	}

	/*private Invoice processInvoiceInfo(Invoice invoice) {
		Invoice invocie = new Invoice();
		
		if(invoiceInfo != null)
			BeanUtils.copyProperties(invoiceInfo, invocie);
		
		return invocie;
		
	}*/

}
