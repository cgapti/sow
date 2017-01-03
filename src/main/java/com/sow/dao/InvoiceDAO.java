package com.sow.dao;

import java.util.List;

import com.sow.exception.SOWException;
import com.sow.model.Invoice;

public interface InvoiceDAO {
	
	List<Invoice> viewInvoice(String sowNo)throws SOWException;

}
