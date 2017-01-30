package com.sow.dao.Impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import com.sow.model.JSON.InvoiceInfo;
import com.sow.model.JSON.SowDetailsInfo;

@Repository("invoiceDAOImpl")
public class InvoiceDAOImpl extends AbstractDao<Integer, SOW> implements
		InvoiceDAO {

	public InvoiceInfo viewInvoice(Invoice invoice) throws SOWException {
		System.out.println("InvoiceDAOImpl - viewInvoice method starts");

		Session session = null;
		Transaction trans = null;
		InvoiceInfo invoiceInfo = null; 
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {

			session = getSession();
			trans = session.beginTransaction();
			String sql = "select SM.SOW_NO,SM.PID,SM.CONTRACT_NO,SM.SOW_REMARKS,SM.PROJECT_DTLS,SM.BUSINESS_AREA,SM.OWNER,SM.CONTRACT_CURRENCY,WO.TECHM_PRJ_DESCR,WO.OB_REMARKS,INV.DIGITAL,INV.INVOICE_NO,INV.UTL_MONTH,INV.INVOICE_DATE,INV.INVOICE_AMT,INV.TAX_AMT,INV.INVOICE_TOTAL_AMT,INV.PAID_AMT,INV.PAYMENT_ID,INV.INVOICE_STATUS,INV.REMARKS from SOW_MS SM,WORK_ORDER WO,INVOICE INV WHERE SM.SOW_NO=WO.SOW_NO  AND SM.SOW_NO=INV.SOW_NO AND WO.MONTH=INV.UTL_MONTH AND INV.SOW_NO ='"
					+ invoice.getSowNo() + "'";
			SQLQuery query = session.createSQLQuery(sql);
			List<Object[]> results = query.list();
			System.out.println("queryList::" + results.size());
			invoiceInfo = new InvoiceInfo();
			SowDetailsInfo sowDetails = new SowDetailsInfo();
			List<SowDetailsInfo> sowDetailsInfoList = new ArrayList<SowDetailsInfo>();
			for (Object[] row : results) {
				String sowNo = "";
				if (row[0] != null && row[0] != "") {
					sowNo = row[0].toString();
					sowDetails.setSowNo(sowNo);
					System.out.println("sowNo:::" + sowNo);
				}
				int pId = 0;
				if (row[1] != null && row[1] != "") {
					pId = Integer.parseInt(row[1].toString());
					sowDetails.setpId(pId);
				}
				String contractNo = "";
				if (row[2] != null && row[2] != "") {
					contractNo = row[2].toString();
					sowDetails.setContractNo(contractNo);
				}
				String sowRemarks = "";
				if (row[3] != null && row[3] != "") {
					sowRemarks = row[3].toString();
					sowDetails.setSowRemarks(sowRemarks);
				}
				String projectDtls = "";
				if (row[4] != null && row[4] != "") {
					projectDtls = row[3].toString();
					sowDetails.setProjectDtls(projectDtls);
				}
				String businessArea = "";
				if (row[5] != null && row[5] != "") {
					businessArea = row[5].toString();
					sowDetails.setBusinessArea(businessArea);
				}
				String owner = "";
				if (row[6] != null && row[6] != "") {
					owner = row[6].toString();
					sowDetails.setOwner(owner);
				}
				String contractCurrency = "";
				if (row[7] != null && row[7] != "") {
					contractCurrency = row[7].toString();
					sowDetails.setContractCurrency(contractCurrency);
				}
				String techMPrjDesc = "";
				if (row[8] != null && row[8] != "") {
					techMPrjDesc = row[8].toString();
					sowDetails.setTechMPrjDesc(techMPrjDesc);
				}
				String obRemarks = "";
				if (row[9] != null && row[9] != "") {
					obRemarks = row[9].toString();
					sowDetails.setObRemarks(obRemarks);
				}
				String digital = "";
				if (row[10] != null && row[10] != "") {
					digital = row[10].toString();
					sowDetails.setDigital(digital);
				}
				Integer invoiceNo = 0;
				if (row[11] != null && row[11] != "") {
					invoiceNo = Integer.parseInt(row[11].toString());
					sowDetails.setInvoiceAmt(invoiceNo);
				}
				String utlMonth = "";
				if (row[12] != null && row[12] != "") {
					utlMonth = row[12].toString();
					sowDetails.setUtlMonth(utlMonth);
				}

				String invoiceDat = "";
				if (row[13] != null && row[13] != "") {
					invoiceDat = row[13].toString();
					Date invoiceDate = df.parse(invoiceDat);
					sowDetails.setInvoiceDate(invoiceDate);
				}
				Integer invoiceAmt = 0;

				if (row[14] != null && row[14] != "") {
					invoiceAmt = Integer.parseInt(row[14].toString());
					sowDetails.setInvoiceAmt(invoiceAmt);
				}

				Integer taxAmt = 0;
				if (row[15] != null && row[15] != "") {
					taxAmt = Integer.parseInt(row[15].toString());
					sowDetails.setTaxAmt(taxAmt);
				}

				String invoiceTotalAmt = "";
				if (row[16] != null && row[16] != "") {
					invoiceTotalAmt = row[16].toString();
					sowDetails.setInvoiceTotalAmt(Integer
							.parseInt(invoiceTotalAmt));
				}

				String paidAmt = "";
				if (row[17] != null && row[17] != "") {
					paidAmt = row[17].toString();
					sowDetails.setPaidAmt(Integer.parseInt(paidAmt));
				}

				String paymentId = "";
				if (row[18] != null && row[18] != "") {
					paymentId = row[18].toString();
					sowDetails.setPaymentId(paymentId);
				}
				String invoiceStatus = "";
				if (row[19] != null && row[19] != "") {
					invoiceStatus = row[19].toString();
					sowDetails.setInvoiceStatus(invoiceStatus);
				}
				String remarks = "";

				if (row[20] != null && row[20] != "") {
					remarks = row[20].toString();
					sowDetails.setInvoiceRemarks(remarks);
				}

				invoiceInfo.setSowInfo(sowDetails);
				sowDetailsInfoList.add(sowDetails);
				invoiceInfo.setSowDetailsInfoList(sowDetailsInfoList);

			}
			

			trans.commit();
		} catch (Exception e) {
			trans.rollback();
			e.printStackTrace();
			throw new SOWException(
					"Error occured while fetching the data from DB",
					e.getMessage());
		}
		System.out.println("InvoiceDAOImpl - viewInvoice method starts");
		return invoiceInfo;

		
	}

}
