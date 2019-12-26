package com.mynrg.dao;

import java.util.ArrayList;
import java.util.List;

import com.mynrg.dto.MyPortalDataBean;
import com.mynrg.model.Portal;



public interface NrgDao {
	// File upload GGL Number validation check 
	public String myPortalReg(Portal portal);
	public List<MyPortalDataBean> myportaltable(List<MyPortalDataBean> myportaltable);
	public Portal myPortalview(int id);
	public String myPortaldelete(int id);
}
