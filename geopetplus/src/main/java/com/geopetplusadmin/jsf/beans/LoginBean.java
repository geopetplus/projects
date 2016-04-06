package com.geopetplusadmin.jsf.beans;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.apache.log4j.Logger;

import com.geopetplusadmin.delegate.LoginDelegate;
import com.geopetplusadmin.delegate.LoginDelegateImpl;
import com.geopetplusadmin.vo.LoginVO;

/**
 * 
 * @author Suresh
 *
 */
@ManagedBean(name = "loginBean")
@SessionScoped
public class LoginBean {
	
	private final static Logger LOGGER = Logger.getLogger(LoginBean.class);
	
	private String message = "Initial Content";
	
	public LoginBean(){
	}
	
	@PostConstruct
	public void init() {
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public void displayMsg() throws Exception {
		this.message = "This is from diaplay Msg()";
	}
	
	public void insertLoginStatus() throws Exception {
		
		LOGGER.info("Invoked LoginBean.java # insertLoginStatus() method");
		
		LoginVO loginVO = new LoginVO();
		
		loginVO.setFacilityid("facilityid");
		
		LoginDelegate loginDelegate = new LoginDelegateImpl();
		if (loginDelegate != null) {
			System.out.println("Step 2");
			String status = loginDelegate.insertLogin(loginVO);
			System.out.println("Step 3:"+status);
			this.message = status;	
		}
		
		LOGGER.info("Exited LoginBean.java # insertLoginStatus() method");
	}
	
}
