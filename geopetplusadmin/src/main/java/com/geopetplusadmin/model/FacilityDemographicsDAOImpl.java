package com.geopetplusadmin.model;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.geopetplusadmin.domain.utility.CommonUtils;
import com.geopetplusadmin.exception.DAOException;
import com.geopetplusadmin.hibernate.admin.FacilityDemographicsDO;
import com.geopetplusadmin.hibernate.admin.LoginDO;

public class FacilityDemographicsDAOImpl extends HibernateDaoSupport implements FacilityDemographicsDAO {
	
	private static String facilityid;
	private static String policyid;
	private static String termid;
	private static String termseqno;
	private static String transid;
	private static String auditid;
	private static String versionid;
	
	private Date currentDate = new Date();
	private Calendar currentCal = new GregorianCalendar();
	
	@Transactional(readOnly = false)
	public String insertDemographics(FacilityDemographicsDO facilityDemographicsDO) throws DAOException {
		
		try {
			
			facilityid = getFaciliyId(facilityDemographicsDO);
			policyid = "P".concat(String.valueOf(currentCal.get(Calendar.YEAR)).concat("1"));
			termid = "TM0001";
			termseqno = "TR".concat(facilityid).concat("1");
			auditid = facilityid.concat(policyid).concat(termseqno).concat(termid);
			versionid = "V1";
			
			//Check if already exist
			/*List<LoginDO> l = (List<LoginDO>) this.getHibernateTemplate().find("from login l where l.facilityid = ? order by l.facilityid desc", facilityId);
			if(l.size()>0) {
				System.out.println("Step 1: l="+l);
				System.out.println("Step 2: l.size="+l.size());
			} else {
				System.out.println("Step 3: l size < 0");
			}*/
			
			// (FacilityID + PolicyNo + termSeqNo + tranID+9999)
			
			//Insert login records
			LoginDO loginData = new LoginDO();
			loginData.setFacilityid(facilityid);
			loginData.setVersionid(versionid);
			loginData.setUserid(facilityid);
			loginData.setPassword(facilityid);
			loginData.setLastupdated(currentDate);
			loginData.setRole("Owner");
			loginData.setStatus("IA");
			loginData.setAuditid(auditid);
	        this.getHibernateTemplate().saveOrUpdate(loginData);
			
	        //Insert demographic records
	        FacilityDemographicsDO demographicData = new FacilityDemographicsDO();
	        demographicData.setFacilityid(facilityid);
	        demographicData.setFacilityname(facilityDemographicsDO.getFacilityname());
	        demographicData.setContactFirstName(facilityDemographicsDO.getContactFirstName());
	        demographicData.setContactLastName(facilityDemographicsDO.getContactLastName());
	        demographicData.setVersionid(versionid);
	        demographicData.setMailAddr1(facilityDemographicsDO.getMailAddr1());
	        demographicData.setMailAddr2(facilityDemographicsDO.getMailAddr2());
	        demographicData.setMailingLocation(facilityDemographicsDO.getMailingLocation());
	        demographicData.setMailingCity(facilityDemographicsDO.getMailingCity());
	        demographicData.setMailingState(facilityDemographicsDO.getMailingState());
	        demographicData.setMailingPincode(facilityDemographicsDO.getMailingPincode());
	        demographicData.setBillAddr1(facilityDemographicsDO.getMailAddr1());
	        demographicData.setBillAddr2(facilityDemographicsDO.getMailAddr2());
	        demographicData.setBillLocation(facilityDemographicsDO.getMailingLocation());
	        demographicData.setBillCity(facilityDemographicsDO.getMailingCity());
	        demographicData.setBillState(facilityDemographicsDO.getMailingState());
	        demographicData.setBillPincode(facilityDemographicsDO.getMailingPincode());
	        demographicData.setFacilityPhone(facilityDemographicsDO.getFacilityPhone());
	        demographicData.setFacilityAltPhone(facilityDemographicsDO.getFacilityAltPhone());
	        demographicData.setFacilyMobileNum(facilityDemographicsDO.getFacilyMobileNum());
	        demographicData.setFacilityWhatsAppNum(facilityDemographicsDO.getFacilityWhatsAppNum());
	        demographicData.setFacilityEmail1(facilityDemographicsDO.getFacilityEmail1());
	        demographicData.setFacilityEmail2(facilityDemographicsDO.getFacilityEmail2());
	        demographicData.setFacilityURL(facilityDemographicsDO.getFacilityURL());
	        demographicData.setFacilityRegStartDate(currentDate);
	        demographicData.setFacilityRegEndDate(currentDate);
	        demographicData.setLastUpdateDate(currentDate);
	        demographicData.setStatus("IA");
	        demographicData.setAuditID(auditid);
	        this.getHibernateTemplate().saveOrUpdate(demographicData);
		}
		catch(Throwable exception) {
			throw new DAOException(exception.getMessage(), exception);
		}
        
        //Insert audit records
		return "Inserted into FacilityDemographics!";
	}
	
	public String getFaciliyId(FacilityDemographicsDO facilityDemographicsDO) {
		CommonUtils getFacilityId = new CommonUtils();
		facilityid = getFacilityId.generateFacilityId(facilityDemographicsDO.getFacilityname(), facilityDemographicsDO.getContactLastName());
		return facilityid;
	}

	public static String getFacilityid() {
		return facilityid;
	}

	public static void setFacilityid(String facilityid) {
		FacilityDemographicsDAOImpl.facilityid = facilityid;
	}

	public static String getPolicyid() {
		return policyid;
	}

	public static void setPolicyid(String policyid) {
		FacilityDemographicsDAOImpl.policyid = policyid;
	}

	public static String getTermid() {
		return termid;
	}

	public static void setTermid(String termid) {
		FacilityDemographicsDAOImpl.termid = termid;
	}

	public static String getTermseqno() {
		return termseqno;
	}

	public static void setTermseqno(String termseqno) {
		FacilityDemographicsDAOImpl.termseqno = termseqno;
	}

	public static String getTransid() {
		return transid;
	}

	public static void setTransid(String transid) {
		FacilityDemographicsDAOImpl.transid = transid;
	}

	public Date getCurrentDate() {
		return currentDate;
	}

	public void setCurrentDate(Date currentDate) {
		this.currentDate = currentDate;
	}

	public static String getAuditid() {
		return auditid;
	}

	public static void setAuditid(String auditid) {
		FacilityDemographicsDAOImpl.auditid = auditid;
	}
	
}
