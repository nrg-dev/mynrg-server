package com.mynrg.service;

import java.io.IOException;
import java.util.ArrayList;

/*import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;*/

//import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.codehaus.jettison.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/*import java.io.IOException;
*/import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
/*import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Collection;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;*/
//import org.springframework.http.MediaType;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;

import com.mynrg.bo.NrgBo;

import com.mynrg.dto.MyPortalDataBean;

@RestController
@SpringBootApplication
public class EndPointService implements Filter{
	
public static final Logger logger = LoggerFactory.getLogger(EndPointService.class);

	
	

@Autowired
NrgBo nrgBo;

	/*enum Industry 
    { 
		CivilEngineering, SoftwareDevelopment, Others; 
    } */

	enum Day 
	{ 
	    SUNDAY,MONDAY,TUESDAY,WEDNESDAY,THURSDAY,FRIDAY,SATURDAY; 
	} 
	
	/*enum Month 
	{ 
		January,February,March,April,May,June,July,August,September,October,November,December; 
	} */
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {

	    HttpServletRequest request = (HttpServletRequest) req;
	    HttpServletResponse response = (HttpServletResponse) res;
	    response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
	    response.setHeader("Access-Control-Allow-Credentials", "true");
	    response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
	    response.setHeader("Access-Control-Max-Age", "3600");
	    response.setHeader("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With, remember-me");
	    chain.doFilter(req, res);
	}

	@Override
	public void init(FilterConfig filterConfig) {
	}

	@Override
	public void destroy() {
	}
	
	ArrayList<String> industryList;
	
	// http://35.162.40.190:80-
	// http://35.162.40.190:80
	
	
	// ---------------------------------------- Common Method ----------------------------------------
	
	
		@PostMapping("/myPortalReg")
		//@CrossOrigin(origins = "http://35.162.40.190:80")
		public String myPortalReg(@RequestBody MyPortalDataBean myportalDataBean)throws JSONException
		{
			System.out.println("--------Inside myPortal Reg------------");
			logger.debug("portalreg");
			String status="Fail"; 
			 Gson gson = null;			
			try{
					
				status = nrgBo.myPortalReg(myportalDataBean);
				logger.debug("portal reg status"+status);
				gson = new Gson();
			}
			catch(Exception e){
				logger.warn("inside exception",e);
				e.printStackTrace();
			}
			return gson.toJson(status);
		}
		
		
}