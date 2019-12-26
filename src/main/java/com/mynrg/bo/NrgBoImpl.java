package com.mynrg.bo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.mynrg.dao.NrgDao;
import com.mynrg.dto.MyPortalDataBean;
import com.mynrg.model.Portal;
import com.mynrg.util.Custom;
import com.mynrg.util.GLGException;


@Service("bo")
public class NrgBoImpl implements NrgBo{
	
	public static final Logger logger = LoggerFactory.getLogger(NrgBoImpl.class);

	
	 @Value("${memeber.silver}")
	 private String silver;
	 @Value("${memeber.gold}")
	 private String gold;
	 @Value("${memeber.platinum}")
	 private String platinum;
	 
	@Autowired
	NrgDao dao;
	
	
	
	@Override
	public String myPortalReg(MyPortalDataBean myportalDataBean) {
		return dao.myPortalReg(myportalDataBean);
	}

	@Override
	public List<MyPortalDataBean> myportaltable(List<MyPortalDataBean> myportaltable) {
		return dao.myportaltable(myportaltable);
	}
	@Override
	public Portal myPortalview(int id) {
		return dao.myPortalview(id);
	}

	
}
