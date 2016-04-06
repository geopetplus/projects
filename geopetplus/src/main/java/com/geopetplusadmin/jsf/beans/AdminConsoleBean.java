package com.geopetplusadmin.jsf.beans;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.apache.log4j.Logger;

import com.geopetplusadmin.delegate.AdminConsoleDelegate;
import com.geopetplusadmin.delegate.AdminConsoleDelegateImpl;
import com.geopetplusadmin.exception.DelegateException;
import com.geopetplusadmin.vo.FacilityDemographicsVO;

/**
 * 
 * @author Suresh
 *
 */
@ManagedBean(name = "adminConsoleBean", eager=true)
@SessionScoped
public class AdminConsoleBean implements Serializable {
	
	private final static Logger LOGGER = Logger.getLogger(AdminConsoleBean.class);
	
	private static final long serialVersionUID = 1L;
	
	private FacilityDemographicsVO facilityDemographicsVO;
	
	private ArrayList<FacilityDemographicsVO> pendingFacilities;
	private ArrayList<FacilityDemographicsVO> filteredfacilities;
	
	public AdminConsoleBean() {}
	
	@PostConstruct
	public void init() {
		LOGGER.info("Start AdminConsoleBean class Init()");
		try {
			AdminConsoleDelegate adminConsoleDelegate = new AdminConsoleDelegateImpl();
			this.pendingFacilities = adminConsoleDelegate.getPendingFacilitiesList();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		LOGGER.info("End AdminConsoleBean class Init()");
		
	}
	
	public ArrayList<FacilityDemographicsVO> getFilteredfacilities() {
		return filteredfacilities;
	}

	public void setFilteredfacilities(ArrayList<FacilityDemographicsVO> filteredfacilities) {
		this.filteredfacilities = filteredfacilities;
	}

	public ArrayList<FacilityDemographicsVO> getPendingFacilities() {
		if (this.pendingFacilities == null) {
			this.pendingFacilities = new ArrayList<FacilityDemographicsVO>();
		}
		return pendingFacilities;
	}

	public void setPendingFacilities(ArrayList<FacilityDemographicsVO> pendingFacilities) {
		this.pendingFacilities = pendingFacilities;
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
}
