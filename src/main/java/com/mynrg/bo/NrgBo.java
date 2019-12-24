package com.mynrg.bo;

import java.util.ArrayList;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mynrg.dto.MyPortalDataBean;



public interface NrgBo {
	
	
	public static final Logger logger = LoggerFactory.getLogger(NrgBo.class);
	public String myPortalReg(MyPortalDataBean myportalDataBean);


}
