package com.geopetplusadmin.jsf.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.geopetplusadmin.delegate.LoginDelegate;
import com.geopetplusadmin.delegate.LoginDelegateImpl;
import com.geopetplusadmin.vo.LoginVO;


@ManagedBean(name = "loginBean")
@SessionScoped
public class LoginBean {
	
	private String message = "Initial Content";
	
	public LoginBean(){}
	
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
		System.out.println("Step 1");
		LoginVO loginVO = new LoginVO();
		
		loginVO.setFacilityid("facilityid");
		
		LoginDelegate loginDelegate = new LoginDelegateImpl();
		if (loginDelegate != null) {
			System.out.println("Step 2");
			String status = loginDelegate.insertLogin(loginVO);
			System.out.println("Step 3:"+status);
			this.message = status;	
		}
	}
	
}
