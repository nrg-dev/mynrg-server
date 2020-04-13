package com.mynrg.dao;

import java.sql.Blob;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.inject.Singleton;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
//import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StreamUtils;

import com.mynrg.dto.MyPortalDataBean;
import com.mynrg.dto.ProductionIssueDataBean;
import com.mynrg.model.Bank;
import com.mynrg.model.Connection;
import com.mynrg.model.Portal;
import com.mynrg.model.ProductionIssue;
import com.mynrg.model.ServerInfo;
import com.mynrg.util.Custom;

//import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.sql.rowset.serial.SerialBlob;



@Repository
@Singleton
public class NrgDaoImpl implements NrgDao {

	public static final Logger logger = LoggerFactory.getLogger(NrgDaoImpl.class);

	@PersistenceContext(unitName="mynrg-pu")
	private EntityManager entitymanager;
	
	/*
	 * @Value("${memeber.silver}") private String silver;
	 * 
	 * @Value("${memeber.gold}") private String gold;
	 * 
	 * @Value("${memeber.platinum}") private String platinum;
	 */
	 

	 
	    
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
				Date updateddate = new Date();
				portal.setUpdatedDate(updateddate);
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
		public boolean save(ProductionIssueDataBean issue) {
			logger.info("Issue Notes-->"+issue.issueNotes);
			logger.info("Clinet name-->"+issue.clientName);
			logger.info("Priority-->"+issue.priority);
			logger.info("Country-->"+issue.country);
			logger.info("base 64-->"+issue.cardImageBase64);
			try {
			
			  byte byte_string[]=issue.getCardImageBase64().getBytes(); 
			  Blob blob= new SerialBlob(byte_string);
			  //ProductionIssue prodissue = new ProductionIssue();
			 
			/*
			 * byte[] byteData = issue.getCardImageBase64().getBytes("UTF-8");//Better to
			 * specify encoding Blob blobData = dbConnection.createBlob();
			 * blobData.setBytes(1, byteData);
			 */
				
				
				ProductionIssue prodissue = new ProductionIssue();
				Date createddate = new Date();
				System.out.println("Before Set the blob");
				prodissue.setCardImageBase64(issue.getCardImageBase64());
				System.out.println("After Set the blob");
				prodissue.setStatus("Active");
				prodissue.setCreatedDate(createddate);
				prodissue.setUpdatedDate(createddate);
				prodissue.setCreatedPerson(issue.getCreatedPerson());
				prodissue.setClientName(issue.getClientName());
				prodissue.setIssueNotes(issue.getIssueNotes());
				prodissue.setPriority(issue.getPriority());
				prodissue.setProduct(issue.getProduct());
				entitymanager.persist(prodissue);
				entitymanager.flush();
				entitymanager.clear();
				//}
			} catch (Exception e) {
				return false;
			}
			return true;
		
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
		
	// Connection		
	
	@Override
	@Transactional(value = "transactionManager")
	public String saveConnection(Connection connection) {

		String status = "Fail";
		try {
			Date createddate = new Date();
			connection.setStatus("Active");
			connection.setCreatedDate(createddate);
			connection.setUpdatedDate(createddate);
			entitymanager.persist(connection);
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
	public String updateConnection(Connection connection) {
		try {
			entitymanager.merge(connection);
			return "success";
		} catch (Exception e) {				
			e.printStackTrace();
			return "fail";
		}
	
	}
	@Override
	@Transactional(value = "transactionManager")
	public List<Connection> loadConnection(List<Connection> connection){
		try {
			Query q = null;
			q = entitymanager.createQuery("from Connection order by updatedDate desc");
			connection = (List<Connection>) q.getResultList();
			return connection;
			} catch (Exception e) {
			e.printStackTrace();
			return connection;
		}
	}
	@Override
	@Transactional(value = "transactionManager")
	public Connection getConnection(int id) {
		Connection connection=null;
		try {
			connection = entitymanager.find(Connection.class, id);
			return connection;
		} catch (Exception e) {				
			e.printStackTrace();
			return connection;
		}

    
	
	}
	@Override
	@Transactional(value = "transactionManager")
	public String removeConnection(int id) {

		Connection connection;
    	String status=null;
		try {
			connection = entitymanager.find(Connection.class, id);
			entitymanager.remove(connection);
			status="success";
			return status;
		} catch (Exception e) {		
			status="fail";
			e.printStackTrace();
			return status;
		}

	
	}

	
	
	   // ServerInfo		
	
		@Override
		@Transactional(value = "transactionManager")
		public String saveServerInfo(ServerInfo serverinfo) {

			String status = "Fail";
			try {
				Date createddate = new Date();
				serverinfo.setStatus("Active");
				serverinfo.setCreatedDate(createddate);
				serverinfo.setUpdated_date(createddate);
				entitymanager.persist(serverinfo);
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
		public String updateServerInfo(ServerInfo serverinfo) {
			try {
				entitymanager.merge(serverinfo);
				return "success";
			} catch (Exception e) {				
				e.printStackTrace();
				return "fail";
			}
		
		}
		@Override
		@Transactional(value = "transactionManager")
		public List<ServerInfo> loadServerInfo(List<ServerInfo> serverinfo){
			try {
				Query q = null;
				q = entitymanager.createQuery("from ServerInfo order by updatedDate desc");
				serverinfo = (List<ServerInfo>) q.getResultList();
				return serverinfo;
				} catch (Exception e) {
				e.printStackTrace();
				return serverinfo;
			}
		}
		@Override
		@Transactional(value = "transactionManager")
		public ServerInfo getServerInfo(int id) {
			ServerInfo serverinfo=null;
			try {
				serverinfo = entitymanager.find(ServerInfo.class, id);
				return serverinfo;
			} catch (Exception e) {				
				e.printStackTrace();
				return serverinfo;
			}

	    
		
		}
		@Override
		@Transactional(value = "transactionManager")
		public String removeServerInfo(int id) {

			ServerInfo serverinfo=null;
	    	String status=null;
			try {
				serverinfo = entitymanager.find(ServerInfo.class, id);
				entitymanager.remove(serverinfo);
				status="success";
				return status;
			} catch (Exception e) {		
				status="fail";
				e.printStackTrace();
				return status;
			}

		
		}
		
		
		
		    // Bank		
			@Override
			@Transactional(value = "transactionManager")
			public String saveBank(Bank bank) {

				String status = "Fail";
				try {
					Date createddate = new Date();
					bank.setStatus("Active");
					bank.setCreatedDate(createddate);
					bank.setUpdatesDate(createddate);
					entitymanager.persist(bank);
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
			public String updateBank(Bank bank) {
				try {
					entitymanager.merge(bank);
					return "success";
				} catch (Exception e) {				
					e.printStackTrace();
					return "fail";
				}
			
			}
			@Override
			@Transactional(value = "transactionManager")
			public List<Bank> loadBank(List<Bank> bank){
				try {
					Query q = null;
					q = entitymanager.createQuery("from Bank order by updatesDate desc");
					bank = (List<Bank>) q.getResultList();
					return bank;
					} catch (Exception e) {
						System.out.println("exception-->"+e.getMessage());
					//e.printStackTrace();
					return bank;
				}
			}
			@Override
			@Transactional(value = "transactionManager")
			public Bank getBank(int id) {
				Bank bank=null;
				try {
					bank = entitymanager.find(Bank.class, id);
					return bank;
				} catch (Exception e) {				
					e.printStackTrace();
					return bank;
				}

		    
			
			}
			@Override
			@Transactional(value = "transactionManager")
			public String removeBank(int id) {

				Bank bank=null;
		    	String status=null;
				try {
					bank = entitymanager.find(Bank.class, id);
					entitymanager.remove(bank);
					status="success";
					return status;
				} catch (Exception e) {		
					status="fail";
					e.printStackTrace();
					return status;
				}

			
			}
			
			
	    
	    
}
