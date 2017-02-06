package com.sow.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import com.sow.exception.SOWException;
import com.sow.model.SOW;
import com.sow.model.SOWCurrency;
import com.sow.model.JSON.SOWCurrencyInfo;
import com.sow.model.JSON.SOWInfo;
import com.sow.model.JSON.SowDetailsInfo;

public abstract class AbstractDao<PK extends Serializable, T> {

	private final Class<T> persistentClass;

	@SuppressWarnings("unchecked")
	public AbstractDao() {
		this.persistentClass = (Class<T>) ((ParameterizedType) this.getClass()
				.getGenericSuperclass()).getActualTypeArguments()[1];
	}

	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession() throws SOWException {
		Session session = sessionFactory.getCurrentSession();
		if (null == session) {
			session = sessionFactory.openSession();
		}
		return session;
	}

	@SuppressWarnings("unchecked")
	public T getByKey(PK key) throws SOWException {
		return (T) getSession().get(persistentClass, key);
	}

	public void persist(T entity) throws SOWException {
		Session session = null;
		Transaction trans = null;
		try {
			session = getSession();
			trans = session.beginTransaction();
			session.persist(entity);
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
			throw new SOWException("Exception occured:", e.getMessage());
		}
	}

	public void saveOrUpdate(T entity) throws SOWException {
		Session session = null;
		Transaction trans = null;
		try {
			session = getSession();
			trans = session.beginTransaction();
			session.saveOrUpdate(entity);
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
			throw new SOWException("Error occured:", e.getMessage());
		}
	}
	public void saveOB(T entity) throws SOWException {
		Session session = null;
		Transaction trans = null;
		try {
			session = getSession();
			trans = session.beginTransaction();
			session.save(entity);
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
			throw new SOWException("Error occured:", e.getMessage());
		}
	}

	public void delete(T entity) throws SOWException {
		Session session = null;
		Transaction trans = null;
		try {
			session = getSession();
			trans = session.beginTransaction();
			session.delete(entity);
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
			throw new SOWException("Error occured:", e.getMessage());
		}
	}

	protected Criteria createEntityCriteria() throws SOWException {
		return getSession().createCriteria(persistentClass);
	}
	
	@SuppressWarnings("unchecked")
	protected List<SOWInfo> createListEntityCriteria() throws SOWException {
		Session session = null;
		Transaction trans = null;
		List<SOWInfo> sowlist = null;
		try {
			session = getSession();
			trans = session.beginTransaction();
			sowlist = session.createCriteria(SOW.class).addOrder(Order.asc("sowNo")).list();
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
			throw new SOWException("Error occured:", e.getMessage());
		}
		return sowlist;
	}

	@SuppressWarnings("unchecked")
	protected List<SowDetailsInfo> createListEntityCriteriaOB()
			throws SOWException {
		Session session = null;
		Transaction trans = null;
		List<SowDetailsInfo> sowDetailslist = null;

		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		try {
			session = getSession();
			trans = session.beginTransaction();

			String sql = "select SM.SOW_NO,SM.PID,SM.CONTRACT_NO,SM.PO_NO,SM.OWNER,SM.ENGMNT_MODEL,SM.PROJECT_DTLS,SM.RES_COUNT,SM.SOW_VALUE_SGD,SM.SOW_VALUE_MYR,SM.SOW_VALUE_INR,SM.CONTRACT_CURRENCY,SM.CURRENCY_RATE,SM.SOW_START_DATE,SM.SOW_END_DATE,TO_CHAR(current_date,'MM')+1 SOWMONTH,SM.SOW_STATUS,SM.location,SM.BUSINESS_AREA,SM.DELIVERY_SPOC,SM.SOW_REMARKS,SM.CUSTOMER_TO_SPOC,SM.CUSTOMER_CC_SPOC,SM.DELIVERY_MODEL,WO.FIN_YEAR,WO.month,WO.TECHM_PRJ_DESCR,WO.CONTRACT_TYPE,WO.PRJ_TOTAL,WO.ACT_TOTAL,WO.OB_REMARKS,INV.INVOICE_NO,INV.DIGITAL,INV.INV_REFERENCE,INV.UTL_MONTH,INV.INVOICE_DATE,INV.INVOICE_AMT,INV.TAX_AMT,INV.INVOICE_TOTAL_AMT,INV.PAID_AMT,INV.PAID_DATE,INV.PAYMENT_ID,INV.INVOICE_STATUS,INV.REMARKS,SM.SOW_VALUE_USD,SM.VALUE_MILLION from SOW_MS SM left join WORK_ORDER WO on SM.SOW_NO=WO.SOW_NO left join INVOICE INV on SM.SOW_NO=INV.SOW_NO and WO.FIN_YEAR between TO_CHAR(SM.SOW_START_DATE,'YYYY') and TO_CHAR(SM.SOW_END_DATE,'YYYY')";
			System.out.println("QUERY IS : " + sql);
			SQLQuery query = session.createSQLQuery(sql);
			List<Object[]> results = query.list();
			System.out.println("queryList::" + results.size());
			sowDetailslist = new ArrayList<SowDetailsInfo>();
			for (Object[] row : results) {
				SowDetailsInfo sowList = new SowDetailsInfo();
				
				String sowNo = "";
				if (row[0] != null && row[0] != "") {
					sowNo = row[0].toString();
					sowList.setSowNo(sowNo);
				}
				Integer pID = 0;
				if (row[1] != null && row[1] != "") {
					pID = Integer.parseInt(row[1].toString());
					sowList.setpId(pID);
				}
				String contractNo = "";
				if (row[2] != null && row[2] != "") {
					contractNo = row[2].toString();
					sowList.setContractNo(contractNo);
				}
				String poNo = "";
				if (row[3] != null && row[3] != "") {
					poNo = row[3].toString();
					sowList.setPoNo(Integer.parseInt(poNo));
				}

				String owner = "";
				if (row[4] != null && row[4] != "") {
					owner = row[4].toString();
					sowList.setOwner(owner);
				}

				String engmntModel = "";

				if (row[5] != null && row[5] != "") {
					engmntModel = row[5].toString();
					sowList.setEngmntModel(engmntModel);
				}

				String projectDtls = "";

				if (row[6] != null && row[6] != "") {
					projectDtls = row[6].toString();
					sowList.setProjectDtls(projectDtls);
				}

				String resCount = "";
				if (row[7] != null && row[7] != "") {
					resCount = row[7].toString();
					sowList.setResCount(Integer.parseInt(resCount));
				}

				String sowValueSgd = "";
				if (row[8] != null && row[8] != "") {
					sowValueSgd = row[8].toString();
					sowList.setSowValueSgd(Integer.parseInt(sowValueSgd));
				}

				String sowValueMyr = "";
				if (row[9] != null && row[9] != "") {
					sowValueMyr = row[9].toString();
					sowList.setSowValueMyr(Integer.parseInt(sowValueMyr));
				}
				String sowValueInr = "";
				if (row[10] != null && row[10] != "") {
					sowValueInr = row[10].toString();
					sowList.setSowValueInr(Integer.parseInt(sowValueInr));
				}
				String contractCcy = "";
				if (row[11] != null && row[11] != "") {
					contractCcy = row[11].toString();
					sowList.setContractCurrency(contractCcy);
				}
				String ccyRate = "";

				if (row[12] != null && row[12] != "") {
					ccyRate = row[12].toString();
					sowList.setCcyRate(ccyRate);
				}

				String startDate = "";
				if (row[13] != null && row[13] != "") {
					startDate = row[13].toString();
					System.out.println("startDate:::" + startDate);
					Date sowStartDate = df.parse(startDate);
					sowList.setSowStartDate(sowStartDate);
				}

				String endDate = "";
				if (row[14] != null && row[14] != "") {
					endDate = row[14].toString();
					System.out.println("endDate:::" + endDate);
					Date sowEndDate = df.parse(endDate);
					sowList.setSowEndDate(sowEndDate);
				}
				String sowMonth = "";
				if (row[15] != null && row[15] != "") {
					sowMonth = row[15].toString();
					sowList.setSowMonth(Integer.parseInt(sowMonth));
				}

				String sowStatus = "";
				if (row[16] != null && row[16] != "") {
					sowStatus = row[16].toString();
					sowList.setSowStatus(sowStatus);
				}

				String location = "";
				if (row[17] != null && row[17] != "") {
					location = row[17].toString();
					sowList.setLocation(location);
				}

				String businessArea = "";
				if (row[18] != null && row[18] != "") {
					businessArea = row[18].toString();
					sowList.setBusinessArea(businessArea);
				}

				String deliverySpoc = "";
				if (row[19] != null && row[19] != "") {
					deliverySpoc = row[19].toString();
					sowList.setDeliverySpoc(deliverySpoc);
				}
				String sowRemarks = "";
				if (row[20] != null && row[20] != "") {
					sowRemarks = row[20].toString();
					sowList.setSowRemarks(sowRemarks);
				}

				String customerToSpoc = "";
				if (row[21] != null && row[21] != "") {
					customerToSpoc = row[21].toString();
					sowList.setCustomerToSpoc(customerToSpoc);
				}
				String customerCcSpoc = "";

				if (row[22] != null && row[22] != "") {
					customerCcSpoc = row[22].toString();
					sowList.setCustomerToSpoc(customerCcSpoc);
				}
				String deliveryModel = "";

				if (row[23] != null && row[23] != "") {
					deliveryModel = row[23].toString();
					sowList.setDeliveryModel(deliveryModel);
				}
				String finYr = "";

				if (row[24] != null && row[24] != "") {
					finYr = row[24].toString();
					sowList.setFinYr(finYr);
				}
				String mon = "";
				if (row[25] != null && row[25] != "") {
					mon = row[25].toString();
					sowList.setMonth(mon);
				}

				String techMPrjDesc = "";

				if (row[26] != null && row[26] != "") {
					techMPrjDesc = row[26].toString();
					sowList.setTechMPrjDesc(techMPrjDesc);
				}

				String contractType = "";

				if (row[27] != null && row[27] != "") {
					contractType = row[27].toString();
					sowList.setContractType(contractType);
				}
				String prjTotal = "";

				if (row[28] != null && row[28] != "") {
					prjTotal = row[28].toString();
					sowList.setPrjTotal(Integer.parseInt(prjTotal));
				}
				String actTotal = "";

				if (row[29] != null && row[29] != "") {
					actTotal = row[29].toString();
					sowList.setActTotal(Integer.parseInt(actTotal));
				}
				String obRemarks = "";

				if (row[30] != null && row[30] != "") {
					obRemarks = row[30].toString();
					sowList.setObRemarks(obRemarks);
				}

				String invoiceNo = "";

				if (row[31] != null && row[31] != "") {
					invoiceNo = row[31].toString();
					sowList.setInvoiceNo(Integer.parseInt(invoiceNo));
				}
				String digital = "";

				if (row[32] != null && row[32] != "") {
					digital = row[32].toString();
					sowList.setDigital(digital);
				}
				String invRef = "";

				if (row[33] != null && row[33] != "") {
					invRef = row[33].toString();
					sowList.setInvReference(invRef);
				}

				String UtlMonth = "";

				if (row[34] != null && row[34] != "") {
					UtlMonth = row[34].toString();
					sowList.setUtlMonth(UtlMonth);
				}

				String invoiceDat = "";
				if (row[35] != null && row[35] != "") {
					invoiceDat = row[35].toString();
					Date invoiceDate = df.parse(invoiceDat);
					sowList.setInvoiceDate(invoiceDate);
				}

				String invoiceAmt = "";
				if (row[36] != null && row[36] != "") {
					invoiceAmt = row[36].toString();
					sowList.setInvoiceAmt(Integer.parseInt(invoiceAmt));
				}

				String taxAmt = "";

				if (row[37] != null && row[37] != "") {
					taxAmt = row[37].toString();
					sowList.setTaxAmt(Integer.parseInt(taxAmt));
				}
				String invoiceTotAmt = "";
				if (row[38] != null && row[38] != "") {
					invoiceTotAmt = row[38].toString();
					sowList.setInvoiceTotalAmt(Integer.parseInt(invoiceTotAmt));
				}
				String paidAmt = "";

				if (row[39] != null && row[39] != "") {
					paidAmt = row[39].toString();
					sowList.setPaidAmt(Integer.parseInt(paidAmt));
				}
				String paidDat = "";
				if (row[40] != null && row[40] != "") {
					paidDat = row[40].toString();
					Date paidDate = df.parse(paidDat);

					sowList.setPaidDate(paidDate);
				}
				String paymentId = "";
				if (row[41] != null && row[41] != "") {
					paymentId = row[41].toString();

					sowList.setPaymentId(paymentId);
				}
				String invoiceStatus = "";

				if (row[42] != null && row[42] != "") {
					invoiceStatus = row[42].toString();
					sowList.setInvoiceStatus(invoiceStatus);
				}
				String invoiceRemarks = "";
				if (row[43] != null && row[43] != "") {
					invoiceRemarks = row[43].toString();

					sowList.setInvoiceRemarks(invoiceRemarks);
				}
				String sowValuetoUSD = "";
				if (row[44] != null && row[44] != "") {
					sowValuetoUSD = row[44].toString();

					sowList.setSowValuetoUSD(sowValuetoUSD);
				}
				String valueMillion = "";
				if (row[45] != null && row[45] != "") {
					valueMillion = row[45].toString();

					sowList.setValueMillion(Integer.parseInt(valueMillion));
				}

				sowDetailslist.add(sowList);
			}

			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
			throw new SOWException("Error occured:", e.getMessage());
		}
		return sowDetailslist;
	}

	@SuppressWarnings("unchecked")
	protected List<SOWInfo> getASOWData(String SOWno) throws SOWException {
		Session session = null;
		Transaction trans = null;
		List<SOWInfo> sowlist = null;
		Criteria cr = null;
		try {
			session = getSession();
			trans = session.beginTransaction();
			cr = session.createCriteria(SOW.class).add( Restrictions.eq("sowNo", SOWno ) );
			sowlist = cr.list();
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
			throw new SOWException("Error occured:", e.getMessage());
		}
		return sowlist;
	}
	
	protected BigDecimal calculatedResult(String curtype, BigDecimal curvalue) throws SOWException {
		Session session = null;
		Transaction trans = null;
		BigDecimal resultvalue = null;
		BigDecimal calculation = null;
		DecimalFormat df = new DecimalFormat("#.#");
		try {
			session = getSession();
			trans = session.beginTransaction();
			Object sow = session.createCriteria(SOWCurrency.class).setProjection(Projections.distinct(Projections.projectionList().add(Projections.property("rate"),"rate"))).add(Restrictions.eq("currency", curtype)).uniqueResult();
			calculation = new BigDecimal(sow.toString());
			resultvalue = curvalue.multiply(calculation);
			resultvalue.setScale(2, BigDecimal.ROUND_UP);
			System.out.println("AbstractDao - calculatedResult::::::"+resultvalue);
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
			throw new SOWException("Error occured:", e.getMessage());
		}
		return resultvalue;
	}
	
	@SuppressWarnings("unchecked")
	protected List<SOW> createListEntityCriteriaForExcel() throws SOWException {
		Session session = null;
		Transaction trans = null;
		List<SOW> sowlist = null;
		try {
			session = getSession();
			trans = session.beginTransaction();
			sowlist = session.createCriteria(SOW.class).addOrder(Order.asc("sowNo")).list();
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
			throw new SOWException("Error occured:", e.getMessage());
		}
		return sowlist;
	}

}