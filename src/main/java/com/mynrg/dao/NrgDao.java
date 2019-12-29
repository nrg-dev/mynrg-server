package com.mynrg.dao;

import java.util.ArrayList;
import java.util.List;

import com.mynrg.dto.MyPortalDataBean;
import com.mynrg.model.Portal;
import com.mynrg.model.ProductionIssue;



public interface NrgDao {
	// File upload GGL Number validation check 
	public String myPortalReg(Portal portal);
	public String myPortalupdate(Portal portal);
	public List<Portal> myportaltable(List<Portal> myportaltable);
	public Portal myPortalview(int id);
	public String myPortaldelete(int id);
	
	
	// Production Issues 
	public String save(ProductionIssue issue);
	public String update(ProductionIssue issue);	
	public List<ProductionIssue> load(List<ProductionIssue> issue);
	public ProductionIssue get(int id);
	public String remove(int id);
		
}
