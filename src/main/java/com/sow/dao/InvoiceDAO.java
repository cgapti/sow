package com.sow.dao;

import com.sow.exception.SOWException;
import com.sow.model.Invoice;

public interface InvoiceDAO {
	
	String viewInvoice(Invoice invoice)throws SOWException;

}
