package com.sow.service;

import java.util.List;

import com.sow.exception.SOWException;
import com.sow.model.Invoice;

public interface InvoiceService {

	List<Invoice> viewInvoice(String sowNo)throws SOWException;
}
