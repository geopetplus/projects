package com.geopetplusadmin.jsf.beans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.geopetplusadmin.delegate.FacilityDemographicsDelegate;
import com.geopetplusadmin.delegate.FacilityDemographicsDelegateImpl;
import com.geopetplusadmin.exception.DelegateException;
import com.geopetplusadmin.vo.FacilityDemographicsVO;

import org.apache.log4j.Logger;

/**
 * 
 * @author Suresh
 *
 */
@ManagedBean(name = "facilityDemographicsBean", eager=true)
@SessionScoped
public class FacilityDemographicsBean implements Serializable {
	
	private final static Logger LOGGER = Logger.getLogger(FacilityDemographicsBean.class);
	
	private static final long serialVersionUID = 1L;
	
	private String message = "Get Status";
	private FacilityDemographicsVO facilityDemographicsVO;
	
	public FacilityDemographicsBean() {
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

	public FacilityDemographicsVO getFacilityDemographicsVO() {
		
		if (this.facilityDemographicsVO == null) {
			this.facilityDemographicsVO = new FacilityDemographicsVO();
		}
		
		return facilityDemographicsVO;
	}

	public void setFacilityDemographicsVO(FacilityDemographicsVO facilityDemographicsVO) {
		this.facilityDemographicsVO = facilityDemographicsVO;
	}
	
	public void saveFacilityDemographics() throws Exception {
		LOGGER.info("Invoked FacilityDemographicsBean.java # saveFacilityDemographics() method");
		try {
			FacilityDemographicsDelegate facilityDemographicsDelegate = new FacilityDemographicsDelegateImpl();
			if (facilityDemographicsDelegate != null && this.facilityDemographicsVO != null) {
				facilityDemographicsDelegate.saveFacilityDemographics(this.facilityDemographicsVO);
				this.message = "Facility Updated!";
			} 
			else {
				this.message = "Error Occured!";
			}
		}
		catch (DelegateException exception) {
			System.out.println(exception.getCause());
			exception.printStackTrace();
		}
		LOGGER.info("Exited FacilityDemographicsBean.java # saveFacilityDemographics() method");
	}
	
	public void resetFacilityDemographics() throws Exception {
		
		LOGGER.info("Invoked FacilityDemographicsBean.java # resetFacilityDemographics() method");
		this.facilityDemographicsVO = null;
		LOGGER.info("Exited FacilityDemographicsBean.java # resetFacilityDemographics() method");
	}

}
