package com.sow.service;

import com.sow.exception.SOWException;
import com.sow.model.Invoice;

public interface InvoiceService {

	String viewInvoice(Invoice invoice)throws SOWException;
}
