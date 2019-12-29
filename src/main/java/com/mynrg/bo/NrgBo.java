package com.mynrg.bo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mynrg.dto.MyPortalDataBean;
import com.mynrg.model.Portal;
import com.mynrg.model.ProductionIssue;



public interface NrgBo {
	
	
	public static final Logger logger = LoggerFactory.getLogger(NrgBo.class);
	// Job portal
	public String myPortalReg(Portal portal);
	public String myPortalupdate(Portal portal);	
	public List<Portal> myportaltable(List<Portal> myportalDataBean);
	public Portal myPortalview(int id);
	public String myPortaldelete(int id);
	
	// Production Issues 
	public String save(ProductionIssue issue);
	public String update(ProductionIssue issue);	
	public List<ProductionIssue> load(List<ProductionIssue> issue);
	public ProductionIssue get(int id);
	public String remove(int id);

	
	
}
