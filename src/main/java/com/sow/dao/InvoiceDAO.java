package com.sow.dao;

import java.util.List;

import com.sow.exception.SOWException;
import com.sow.model.Invoice;
import com.sow.model.JSON.InvoiceInfo;

public interface InvoiceDAO {
	
	InvoiceInfo viewInvoice(Invoice invoice)throws SOWException;

}
