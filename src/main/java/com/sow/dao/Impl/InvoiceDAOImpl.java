package com.sow.dao.Impl;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.sow.dao.AbstractDao;
import com.sow.dao.InvoiceDAO;
import com.sow.exception.SOWException;
import com.sow.model.Invoice;
import com.sow.model.SOW;

@Repository("/invoiceDAOImpl")
public class InvoiceDAOImpl extends AbstractDao<Integer, SOW> implements
		InvoiceDAO {

	public List<Invoice> viewInvoice(String sowNo) throws SOWException {
		System.out.println("InvoiceDAOImpl - viewInvoice method starts");

		Session session = null;
		Transaction trans = null;
		List<Invoice> results = null;
		try {
			session = getSession();
			trans = session.beginTransaction();
			String sql = "SELECT * FROM INVOICE WHERE SOW_NO = '"
					+ sowNo + "'";
			SQLQuery query = session.createSQLQuery(sql);
			results = query.list();
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
			throw new SOWException(
					"Error occured while fetching the data from DB",
					e.getMessage());
		}
		System.out.println("InvoiceDAOImpl - viewInvoice method starts");
		return results;
		
		/*List<Invoice> invoices = new ArrayList<Invoice>();
		
		Invoice invoice1 = new Invoice();
		invoice1.setSowNo("111");
		invoice1.setInvoiceNo(111);
		invoices.add(invoice1);
		
		Invoice invoice2 = new Invoice();
		invoice1.setSowNo("112");
		invoice1.setInvoiceNo(112);
		invoices.add(invoice2);
		return invoices;*/
	}

}
