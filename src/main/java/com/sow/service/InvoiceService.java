package com.sow.service;

import java.util.List;

import com.sow.exception.SOWException;
import com.sow.model.Invoice;
import com.sow.model.JSON.InvoiceInfo;

public interface InvoiceService {

	InvoiceInfo viewInvoice(Invoice invoice)throws SOWException;
}
