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
import com.mynrg.model.ProductionIssue;
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
	 

	 
	    
	 	/* Portal */
	 	
	 	// save
	 	@Transactional(value = "transactionManager")
		@Override
		public String myPortalReg(Portal portal) {
			String status = "Fail";
			try {
					Date createddate = new Date();
					portal.setStatus("Active");
					portal.setCreatedDate(createddate);
					portal.setUpdatedDate(createddate);
					entitymanager.persist(portal);
					entitymanager.flush();
					entitymanager.clear();
					status = "success";
				//}
			} catch (Exception e) {

			}
			return status;
		}
	    
	    // load
	    @Transactional(value = "transactionManager")
	    @Override
		public List<Portal> myportaltable(
				List<Portal> myportaltable) {
			//List<MyPortalDataBean> list = new ArrayList<MyPortalDataBean>();
			try {
				Query q = null;
				q = entitymanager.createQuery("from Portal");
				myportaltable = (List<Portal>) q.getResultList();
					} catch (Exception e) {
				e.printStackTrace();
			}
			return myportaltable;
		}
	    
		// get
	    @Transactional(value = "transactionManager")
	    @Override
	    public Portal myPortalview(int id) {
	    	Portal portal=null;
			try {
				portal = entitymanager.find(Portal.class, id);
				return portal;
			} catch (Exception e) {				
				e.printStackTrace();
				return portal;
			}
	
	    }
	    
	    // update
	    @Transactional(value = "transactionManager")
	    @Override
		public String myPortalupdate(Portal portal) {
			try {
				entitymanager.merge(portal);
				return "success";
			} catch (Exception e) {				
				e.printStackTrace();
				return "fail";
			}
	
	    
		}
		
	    
	    // remove	    
	    @Transactional(value = "transactionManager")
	    @Override
	    public String myPortaldelete(int id) {
	    	Portal portal=null;
	    	String status=null;
			try {
				portal = entitymanager.find(Portal.class, id);
				entitymanager.remove(portal);
				status="success";
				return status;
			} catch (Exception e) {		
				status="fail";
				e.printStackTrace();
				return status;
			}
			//return portal;
		
	    }
	    
	    /* Production Issues */
	    
		@Override
		@Transactional(value = "transactionManager")
		public String save(ProductionIssue issue) {
			String status = "Fail";
			try {
				Date createddate = new Date();
				issue.setStatus("Active");
				issue.setCreatedDate(createddate);
				issue.setUpdatedDate(createddate);
				entitymanager.persist(issue);
				entitymanager.flush();
				entitymanager.clear();
				status = "success";
				//}
			} catch (Exception e) {

			}
			return status;
		
		}
		
		@Override
		@Transactional(value = "transactionManager")
		public String update(ProductionIssue issue) {
			try {
				entitymanager.merge(issue);
				return "success";
			} catch (Exception e) {				
				e.printStackTrace();
				return "fail";
			}
		}
		
		@Override
		@Transactional(value = "transactionManager")
		public List<ProductionIssue> load(List<ProductionIssue> issue){
			try {
				Query q = null;
				q = entitymanager.createQuery("from ProductionIssue order by updatedDate desc");
				issue = (List<ProductionIssue>) q.getResultList();
					} catch (Exception e) {
				e.printStackTrace();
			}
			return issue;
		
		}
		
		@Override
		@Transactional(value = "transactionManager")
		public ProductionIssue get(int id) {

			ProductionIssue issue=null;
			try {
				issue = entitymanager.find(ProductionIssue.class, id);
				return issue;
			} catch (Exception e) {				
				e.printStackTrace();
				return issue;
			}
	
	    
		}
		
		@Override
		@Transactional(value = "transactionManager")
		public String remove(int id) {
			ProductionIssue issue=null;
	    	String status=null;
			try {
				issue = entitymanager.find(ProductionIssue.class, id);
				entitymanager.remove(issue);
				status="success";
				return status;
			} catch (Exception e) {		
				status="fail";
				e.printStackTrace();
				return status;
			}

		}
	    
	    
}
