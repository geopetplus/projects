package com.geopetplusadmin.model;

import java.util.Date;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.geopetplusadmin.domain.utility.CommonUtils;
import com.geopetplusadmin.hibernate.admin.AdminDemographicsDO;

public class AdminDemographicsDAOImpl extends HibernateDaoSupport implements AdminDemographicsDAO {
	
	private static String adminId;
	
	@Transactional(readOnly = false)
	public String insertDemographics(String getAdminId) throws Exception {
		
		adminId = getAdminId;
		
        AdminDemographicsDO demog = new AdminDemographicsDO();
        demog.setAdminid(adminId);
        demog.setAdminFirstName("adminFirstName");
        demog.setAdminLastName("adminLastName");
        demog.setMailAddr1("mailAddr1");
        demog.setMailAddr2("mailAddr2");
        demog.setMailingLocation("mailingLocation");
        demog.setMailingCity("mailingCity");
        demog.setMailingState("mailingState");
        demog.setMailingPincode("Pincode");
        demog.setAdminPhone("Phone");
        demog.setAltAdminPhone("altPhone");
        demog.setAdminMobileNum("Mobile");
        demog.setAdminEmail("adminEmail");
       // demog.setFacilityEmail2("adminEmail2");
        
        Date testDate = new Date();
        demog.setAdminRegStartDate(testDate);
        demog.setAdminRegEndDate(testDate);
        demog.setLastUpdateDate(testDate);
        demog.setStatus("sts");
        demog.setAuditID("auditID");
        
        //this.getHibernateTemplate().getSessionFactory().getCurrentSession().setFlushMode(FlushMode.AUTO);        
        this.getHibernateTemplate().saveOrUpdate(demog);
        //detached criteria using hibernatetemplate
        
		return "Inserted into FacilityDemographics!";
	}
}
