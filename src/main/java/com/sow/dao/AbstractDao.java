package com.sow.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import com.sow.exception.SOWException;
import com.sow.model.SOW;
import com.sow.model.SOWCurrency;
import com.sow.model.JSON.SOWCurrencyInfo;
import com.sow.model.JSON.SOWInfo;

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
			sowlist = session.createCriteria(SOW.class).list();
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
			throw new SOWException("Error occured:", e.getMessage());
		}
		return sowlist;
	}
	
	@SuppressWarnings("unchecked")
	protected List<SOWInfo> getASOWData(String SOWno) throws SOWException {
		Session session = null;
		Transaction trans = null;
		List<SOWInfo> sowlist = null;
		try {
			session = getSession();
			trans = session.beginTransaction();
			sowlist = session.createCriteria(SOW.class).add( Restrictions.eq("sowNo", SOWno ) ).list();
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
		try {
			session = getSession();
			trans = session.beginTransaction();
			Object sow = session.createCriteria(SOWCurrency.class).setProjection(Projections.distinct(Projections.projectionList().add(Projections.property("rate"),"rate"))).add(Restrictions.eq("currency", curtype)).uniqueResult();
			calculation = new BigDecimal(sow.toString());
			resultvalue = curvalue.multiply(calculation);
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
			throw new SOWException("Error occured:", e.getMessage());
		}
		return resultvalue;
	}

}