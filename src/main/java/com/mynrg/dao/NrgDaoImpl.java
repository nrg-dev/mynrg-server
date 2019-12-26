package com.mynrg.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.inject.Singleton;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
//import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mynrg.dto.MyPortalDataBean;
import com.mynrg.model.Portal;
import com.mynrg.util.Custom;

//import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;



@Repository
@Singleton
public class NrgDaoImpl implements NrgDao {

	public static final Logger logger = LoggerFactory.getLogger(NrgDaoImpl.class);

	@PersistenceContext(unitName="mynrg-pu")
	private EntityManager entitymanager;
	
	 @Value("${memeber.silver}")
	 private String silver;
	 @Value("${memeber.gold}")
	 private String gold;
	 @Value("${memeber.platinum}")
	 private String platinum;
	 

	 
	    @Transactional(value = "transactionManager")
		@Override
		public String myPortalReg(MyPortalDataBean myportalDataBean) {
			String status = "Fail";
			try {
			/*	Query q1 = null;
				q1 = entitymanager
						.createQuery("from Portal where portalName=? and status=?");
				q1.setParameter(1, myportalDataBean.getPortalname());
				q1.setParameter(2, "Active");
				List<Portal> portalresult = (List<Portal>) q1.getResultList();
				if (portalresult.size() > 0) {

					status = "Exsist";
				} else { */
					Date createddate = new Date();
					Portal portal = new Portal();
					portal.setPortalName(myportalDataBean.getPortalname());
					portal.setCountry(myportalDataBean.getCountry());
					portal.setUrl(myportalDataBean.getUrl());
					portal.setEmailId1(myportalDataBean.getEmailID());
					/* portal.setEmailId2(myportalDataBean.get); */
					portal.setUserName(myportalDataBean.getUsername());
					portal.setPassword(myportalDataBean.getPassword());
					portal.setPhoneNumber1(myportalDataBean.getPhonenumber());
					/* portal.setPhoneNumber2(myportalDataBean.); */
					portal.setCreatedDate(createddate);
					portal.setCreatedPerson(myportalDataBean.currentUser);
					portal.setStatus("Active");
					entitymanager.persist(portal);
					entitymanager.flush();
					entitymanager.clear();
					status = "success";
				//}
			} catch (Exception e) {

			}
			return status;
		}
	    
	    @Transactional(value = "transactionManager")
	    @Override
		public List<MyPortalDataBean> myportaltable(
				List<MyPortalDataBean> myportaltable) {
			List<MyPortalDataBean> list = new ArrayList<MyPortalDataBean>();
			try {
				Query q = null;
				q = entitymanager.createQuery("from Portal");
				List<Portal> portaltablelist = (List<Portal>) q.getResultList();
				for(Portal p : portaltablelist) {
					MyPortalDataBean myportaldataBean = new MyPortalDataBean();
					myportaldataBean.setPortalname(p.getPortalName());
					myportaldataBean.setCountry(p.getCountry());
					myportaldataBean.setUrl(p.getUrl());
					myportaldataBean.setUsername(p.getUserName());
					myportaldataBean.setPassword(p.getPassword());
					myportaldataBean.setId(p.getPortalId());
					list.add(myportaldataBean);

				}

			} catch (Exception e) {
				e.printStackTrace();
			}
			return list;
		}
			
	    public Portal myPortalview(int id) {
	    	Portal portal=null;
			try {
				portal = entitymanager.find(Portal.class, id);
				return portal;
			} catch (Exception e) {				
				e.printStackTrace();
				return portal;
			}
			//return portal;
		
	    }
	    
}
