package com.geopetplusadmin.jsf.beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.geopetplusadmin.delegate.FacilityDemographicsDelegate;
import com.geopetplusadmin.delegate.FacilityDemographicsDelegateImpl;
import com.geopetplusadmin.exception.DelegateException;
import com.geopetplusadmin.vo.FacilityDemographicsVO;

/**
 * 
 * @author Suresh Kumar Mahalingam
 *
 */
@ManagedBean(name="facilityDemographicsBean")
@SessionScoped
public class FacilityDemographicsBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String message = "Get Status";
	private FacilityDemographicsVO facilityDemographicsVO;
	
	public FacilityDemographicsBean() {}
	
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
	
	public void insertStatus() throws Exception {
		
		try {
		
			FacilityDemographicsDelegate facilityDemographicsDelegate = new FacilityDemographicsDelegateImpl();
			
			if (facilityDemographicsDelegate != null 
					&& this.facilityDemographicsVO != null) {
				
				String status = facilityDemographicsDelegate.insertDemographics(this.facilityDemographicsVO);
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
	}

}
