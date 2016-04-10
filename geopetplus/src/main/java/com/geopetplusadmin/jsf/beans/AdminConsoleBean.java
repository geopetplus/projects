package com.geopetplusadmin.jsf.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

import org.apache.log4j.Logger;

import com.geopetplusadmin.delegate.AdminConsoleDelegate;
import com.geopetplusadmin.delegate.AdminConsoleDelegateImpl;
import com.geopetplusadmin.exception.DelegateException;
import com.geopetplusadmin.hibernate.admin.FacilityDemographicsDO;
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
	
	private ArrayList<FacilityDemographicsDO> pendingFacilities;
	private ArrayList<FacilityDemographicsDO> filteredfacilities;
	
	private AdminConsoleDelegate adminConsoleDelegate;
	
	private String facilityid = "Dummy" ;
	
	public AdminConsoleBean() {}
	
	@PostConstruct
	public void init() {
		LOGGER.info("Start AdminConsoleBean class Init()");
		try {
			adminConsoleDelegate = new AdminConsoleDelegateImpl();
			this.pendingFacilities = adminConsoleDelegate.getPendingFacilitiesList();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		LOGGER.info("End AdminConsoleBean class Init()");	
	}
	
	public String loadFacilityInfo() throws DelegateException {
		LOGGER.info("Invoked AdminConsoleBean.java # loadFacilityInfo() method");
		Map<String,String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		System.out.println("Suresh 1: param1="+params.get("facilityid"));	
		if(params.get("facilityid") != null) {
			adminConsoleDelegate = new AdminConsoleDelegateImpl();
			this.facilityDemographicsVO = adminConsoleDelegate.getFacilityInfo(params.get("facilityid"));
			System.out.println("Suresh 11: facilityInfo="+this.facilityDemographicsVO);
			return "/pages/admin/adminTransaction.xhtml?faces-redirect=true";
		} else {
			System.out.println("Suresh 14: Is NULL");
			return "/pages/admin/adminConsole.xhtml?faces-redirect=true";
		}
		
	}
	
	public ArrayList<FacilityDemographicsDO> getFilteredfacilities() {
		return filteredfacilities;
	}

	public void setFilteredfacilities(ArrayList<FacilityDemographicsDO> filteredfacilities) {
		this.filteredfacilities = filteredfacilities;
	}

	public ArrayList<FacilityDemographicsDO> getPendingFacilities() {
		if (this.pendingFacilities == null) {
			this.pendingFacilities = new ArrayList<FacilityDemographicsDO>();
		}
		return pendingFacilities;
	}

	public void setPendingFacilities(ArrayList<FacilityDemographicsDO> pendingFacilities) {
		this.pendingFacilities = pendingFacilities;
	}
	
	public String getFacilityid() {
		return facilityid;
	}

	public void setFacilityid(String facilityid) {
		this.facilityid = facilityid;
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
