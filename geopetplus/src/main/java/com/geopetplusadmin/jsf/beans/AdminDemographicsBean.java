package com.geopetplusadmin.jsf.beans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.geopetplusadmin.delegate.AdminDemographicsDelegate;
import com.geopetplusadmin.delegate.AdminDemographicsDelegateImpl;
import com.geopetplusadmin.exception.DelegateException;
import com.geopetplusadmin.vo.AdminDemographicsVO;

import org.apache.log4j.Logger;

/**
 * 
 * @author Senthil
 *
 */
@ManagedBean(name = "adminDemographicsBean", eager=true)
@SessionScoped
public class AdminDemographicsBean implements Serializable {
	
	private final static Logger LOGGER = Logger.getLogger(AdminDemographicsBean.class);
	
	private static final long serialVersionUID = 1L;
	
	private String message = "Get Status";
	private AdminDemographicsVO adminDemographicsVO;
	
	public AdminDemographicsBean() {
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

	public AdminDemographicsVO getAdminDemographicsVO() {
		
		if (this.adminDemographicsVO == null) {
			this.adminDemographicsVO = new AdminDemographicsVO();
		}
		
		return adminDemographicsVO;
	}

	public void setAdminDemographicsVO(AdminDemographicsVO adminDemographicsVO) {
		this.adminDemographicsVO = adminDemographicsVO;
	}
	
	public void saveAdminDemographics() throws Exception {
		LOGGER.info("Invoked AdminDemographicsBean.java # saveAdminDemographics() method");
		try {
			AdminDemographicsDelegate adminDemographicsDelegate = new AdminDemographicsDelegateImpl();
			if (adminDemographicsDelegate != null && this.adminDemographicsVO != null) {
				String status = adminDemographicsDelegate.saveAdminDemographics(this.adminDemographicsVO);
				this.message = status;
			} 
			else {
				this.message = "Error Occured!";
			}
		}
		catch (DelegateException exception) {
			System.out.println(exception.getCause());
			exception.printStackTrace();
		}
		LOGGER.info("Exited AdminDemographicsBean.java # saveAdminDemographics() method");
	}
	
	public void resetAdminDemographics() throws Exception {
		
		LOGGER.info("Invoked AdminDemographicsBean.java # resetAdminDemographics() method");
		this.adminDemographicsVO = null;
		LOGGER.info("Exited AdminDemographicsBean.java # resetAdminDemographics() method");
	}

}
