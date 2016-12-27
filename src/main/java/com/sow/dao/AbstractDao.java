package com.sow.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.sow.exception.SOWException;

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

}