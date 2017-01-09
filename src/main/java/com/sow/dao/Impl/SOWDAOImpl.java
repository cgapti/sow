package com.sow.dao.Impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.springframework.stereotype.Repository;

import com.sow.dao.AbstractDao;
import com.sow.dao.SOWDAO;
import com.sow.exception.SOWException;
import com.sow.model.SOW;
import com.sow.model.JSON.SOWInfo;

@Repository("/sowDAOImpl")
public class SOWDAOImpl extends AbstractDao<Integer, SOW> implements
		SOWDAO {
	SOW sow;
	public Integer featchSowNoSeed()throws SOWException{
		/*DetachedCriteria criteria = DetachedCriteria.forClass(SOW.class).setProjection(Projections.max("SOW_NO_SEED"));
		SOW sow =(SOW) criteria.getExecutableCriteria(getSession()).list().get(0);*/
		Session session = getSession();
		Transaction trans = session.beginTransaction();
		
		/*SQLQuery query = session.createSQLQuery(
				"SELECT max(PID) FROM SOW_MS")
			    .addEntity(SOW.class);
		SOW sow=(SOW)query.addEntity(SOW.class);
		System.out.println("Inside SOWDAOImpl:"+sow.getpId());*/
		
		/*Criteria cr = session.createCriteria(SOW.class);
		cr.setProjection(Projections.projectionList()
		            .add(Projections.max("number")));*/
		
		Criteria criteria = session
			    .createCriteria(SOW.class)
			    .setProjection(Projections.max("sowNoSeed"));
			Integer sowNoSeed = (Integer)criteria.uniqueResult();		
			
			System.out.println("Inside SOWDAOImpl sowNoSeed:"+sowNoSeed);
			trans.commit();
		return sowNoSeed+1;
	}
	
	public String saveAddSOW(SOW addSOW)throws SOWException{
		System.out.println("SOWDAOImpl - saveAddSOW method starts");
		saveOrUpdate(addSOW);
		System.out.println("SOWDAOImpl - saveAddSOW method starts");
		return "success";
	}
	
	
	public List<SOWInfo> fetchSOWData()throws SOWException{
		System.out.println("SOWDAOImpl - fetchSOW method starts");
		List<SOWInfo> allSOW = new ArrayList<SOWInfo>();
		if (allSOW == null || allSOW.isEmpty()) {
			allSOW = createListEntityCriteria();
		}
		System.out.println("SOWDAOImpl - fetchSOW method ends");
		return allSOW;
	}

	public List<SOWInfo> fetchASOWData(String SOWno)throws SOWException{
		System.out.println("SOWDAOImpl - fetchASOWData method starts");
		List<SOWInfo> SOW = new ArrayList<SOWInfo>();
		if (SOW == null || SOW.isEmpty()) {
			SOW = getASOWData(SOWno);
		}
		System.out.println("SOWDAOImpl - fetchASOWData method ends");
		return SOW;
	}

	public BigDecimal currCalculation(String curtype, BigDecimal curvalue)throws SOWException{
		System.out.println("SOWDAOImpl - currCalculation method starts");
		BigDecimal resultvalue = null;
		resultvalue = calculatedResult(curtype, curvalue);
		System.out.println("SOWDAOImpl - currCalculation method starts");
		return resultvalue;
	}
	
	public Integer featchSowRefNo()throws SOWException{
		Session session = getSession();
		Integer sowNoSeed;
		System.out.println("SOWDAOImpl - featchSowRefNo method starts");
		Criteria criteria = session
			    .createCriteria(SOW.class)
			    .setProjection(Projections.max("sowNoSeed"));
			sowNoSeed = (Integer)criteria.uniqueResult();
			
		System.out.println("SOWDAOImpl - featchSowRefNo method starts");
		return sowNoSeed + 1;
	}

	
}
