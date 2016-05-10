package com.geopetplusadmin.jsf.beans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.geopetplusadmin.delegate.LoginDelegate;
import com.geopetplusadmin.delegate.LoginDelegateImpl;
import com.geopetplusadmin.exception.DelegateException;
import com.geopetplusadmin.vo.LoginVO;

import org.apache.log4j.Logger;

/**
 * 
 * @author Senthil
 *
 */
@ManagedBean(name = "loginBean", eager=true)
@SessionScoped
public class LoginBean implements Serializable {
	
	private final static Logger LOGGER = Logger.getLogger(LoginBean.class);
	
	private static final long serialVersionUID = 1L;
	
	private String message = "Get Status";
	private LoginVO loginVO;
	
	public LoginBean() {
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

	public LoginVO getLoginVO() {
		
		if (this.loginVO == null) {
			this.loginVO = new LoginVO();
		}
		
		return loginVO;
	}

	public void setLoginVO(LoginVO loginVO) {
		this.loginVO = loginVO;
	}
	
	public String verifyLogin() throws Exception {
		LOGGER.info("Invoked LoginBean.java # verifyLogin() method");
		String result;
		String status = "";
		try {
			LoginDelegate loginDelegate = new LoginDelegateImpl();
			if (loginDelegate != null && this.loginVO != null) {
				result = loginDelegate.verifyLogin(this.loginVO);
				
				if (result.equals("matched")){ 
				
					//this.message = "Login successful!";
					status = "success";
				
				} 
				else if  (result.equals("notfound")){ 
					
					this.message = "User id not found!";
					status = "notsuccess";
				}
				else if  (result.equals("notmatched")){ 
					
					this.message = "Password is invalid!";
					status = "notsuccess";
				}
				
				else {
					this.message = "Error Occured!";
					status = "notsuccess";
				}
			}
		}
		catch (DelegateException exception) {
			System.out.println(exception.getCause());
			exception.printStackTrace();
		}
		
		LOGGER.info("Exited LoginBean.java # verifyLogin() method");
		return status;
	}
	
	public void resetLogin() throws Exception {
		
		LOGGER.info("Invoked LoginBean.java # resetLogin() method");
		this.loginVO = null;
		LOGGER.info("Exited LoginBean.java # resetLogin() method");
	}

}
