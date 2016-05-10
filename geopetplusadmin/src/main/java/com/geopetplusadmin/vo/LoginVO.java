package com.geopetplusadmin.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class LoginVO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String loginid;
	private String password;
	
		
	public LoginVO(){}

	public LoginVO(String loginid, String password) {
		super();
		this.loginid = loginid;
		this.password = password;
		
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLoginid() {
		return loginid;
	}

	public void setLoginid(String loginid) {
		this.loginid = loginid;
	}


	@Override
	public String toString() {
		return "LoginVO [loginid=" + loginid + ", password=" + password + "]";
	}
	
}
