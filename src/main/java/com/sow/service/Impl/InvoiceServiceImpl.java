package com.sow.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sow.dao.Impl.InvoiceDAOImpl;
import com.sow.exception.SOWException;
import com.sow.model.Invoice;
import com.sow.model.JSON.InvoiceInfo;
import com.sow.service.InvoiceService;

@Service("invoiceServiceImpl")
public class InvoiceServiceImpl implements InvoiceService {
	
	@Autowired
	private InvoiceDAOImpl invoiceDAOImpl;;
	
	public InvoiceInfo viewInvoice(Invoice invoice) throws SOWException {
		System.out.println("SowServiceImpl - addSOW method starts");
		System.out.println("SowServiceImpl - addSOW method ends");
		return invoiceDAOImpl.viewInvoice(invoice);
	}

}
