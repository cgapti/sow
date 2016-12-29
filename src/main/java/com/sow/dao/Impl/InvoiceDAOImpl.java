package com.sow.dao.Impl;

import org.springframework.stereotype.Repository;

import com.sow.dao.AbstractDao;
import com.sow.dao.InvoiceDAO;
import com.sow.exception.SOWException;
import com.sow.model.Invoice;
import com.sow.model.SOW;

@Repository("/invoiceDAOImpl")
public class InvoiceDAOImpl extends AbstractDao<Integer, SOW> implements
		InvoiceDAO {

	public String viewInvoice(Invoice invoice) throws SOWException {
		System.out.println("InvoiceDAOImpl - viewInvoice method starts");
		viewInvoice(invoice);
		System.out.println("InvoiceDAOImpl - viewInvoice method starts");
		return "success";
	}

}
