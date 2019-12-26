package com.mynrg.bo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mynrg.dto.MyPortalDataBean;
import com.mynrg.model.Portal;



public interface NrgBo {
	
	
	public static final Logger logger = LoggerFactory.getLogger(NrgBo.class);
	public String myPortalReg(MyPortalDataBean myportalDataBean);
	public List<MyPortalDataBean> myportaltable(List<MyPortalDataBean> myportalDataBean);
	public Portal myPortalview(int id);

	
}
