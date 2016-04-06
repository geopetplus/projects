package com.geopetplusadmin.service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Calendar;
import org.springframework.transaction.annotation.Transactional;

import com.geopetplusadmin.domain.utility.CommonUtils;
import com.geopetplusadmin.domain.utility.TranformationUtils;
import com.geopetplusadmin.exception.DAOException;
import com.geopetplusadmin.exception.ServiceException;
import com.geopetplusadmin.hibernate.admin.AuditDO;
import com.geopetplusadmin.hibernate.admin.FacilityDemographicsDO;
import com.geopetplusadmin.hibernate.admin.LoginDO;
import com.geopetplusadmin.hibernate.admin.TransactionServicesDO;
import com.geopetplusadmin.model.FacilityDemographicsDAO;
import com.geopetplusadmin.model.FacilityDemographicsDAOImpl;
import com.geopetplusadmin.vo.FacilityDemographicsVO;

public class FacilityDemographicsServiceImpl implements FacilityDemographicsService {
	
	FacilityDemographicsDAO facilityDemographicsDAO;
	
	@Transactional(readOnly = false)
	public String saveFacilityDemographics(FacilityDemographicsVO facilityDemographicsVO) throws ServiceException {
		
		try {
			FacilityDemographicsDO facilityDemographicsDO = TranformationUtils.transformFacilityDemographicsVO(facilityDemographicsVO);
			String facilityid = CommonUtils.generateFacilityId(facilityDemographicsDO.getFacilityname());
			BigInteger facilityseq = facilityDemographicsDAO.getSequence("facilityseq");
			facilityseq = facilityseq.add(BigInteger.ONE);
			facilityid = facilityid.concat(facilityseq.toString());
			System.out.println("Suresh: facilityid="+facilityid);
			
			String policyid = "PL".concat(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)).concat("0"));
			BigInteger policyseq = facilityDemographicsDAO.getSequence("policyseq");
			policyseq = policyseq.add(BigInteger.ONE);
			policyid = policyid.concat(policyseq.toString());
			System.out.println("Suresh: policyid="+policyid);
			
			String transactionseqnbr = "TR".concat(facilityid).concat("0");
			BigInteger transseq = facilityDemographicsDAO.getSequence("transseq");
			transseq = transseq.add(BigInteger.ONE);
			transactionseqnbr = transactionseqnbr.concat(transseq.toString());
			System.out.println("Suresh: transactionseqnbr="+transactionseqnbr);
			
			String auditid = "AUD".concat(facilityid).concat("0");
			BigInteger auditseq = facilityDemographicsDAO.getSequence("auditseq");
			auditseq = auditseq.add(BigInteger.ONE);
			auditid = auditid.concat(auditseq.toString());
			System.out.println("Suresh: auditid="+auditid);
			
			String termid = "T1";
			String versionid = "V1";
			
			facilityDemographicsDO.setFacilityid(facilityid);
			facilityDemographicsDO.setVersionid(versionid);
			//if billing address is same as mailing address
			facilityDemographicsDO.setBillAddr1(facilityDemographicsDO.getMailAddr1());
			facilityDemographicsDO.setBillAddr2(facilityDemographicsDO.getMailAddr2());
			facilityDemographicsDO.setBillCity(facilityDemographicsDO.getMailingCity());
			facilityDemographicsDO.setBillLocation(facilityDemographicsDO.getMailingLocation());
			facilityDemographicsDO.setBillPincode(facilityDemographicsDO.getMailingPincode());
			facilityDemographicsDO.setBillState(facilityDemographicsDO.getMailingState());
			facilityDemographicsDO.setFacilityRegStartDate(CommonUtils.getCurrentDate());
			facilityDemographicsDO.setFacilityRegEndDate(CommonUtils.getCurrentDate());
			facilityDemographicsDO.setLastUpdateDate(CommonUtils.getCurrentDate());
			facilityDemographicsDO.setStatus("IA");
			facilityDemographicsDO.setAuditID(auditid);
			System.out.println("Suresh: facilityDemographicsDO="+facilityDemographicsDO);

			
			//Insert login records
			LoginDO loginDO = new LoginDO();
			loginDO.setFacilityid(facilityid);
			loginDO.setVersionid(versionid);
			loginDO.setUserid(facilityid);
			loginDO.setPassword(facilityid);
			loginDO.setLastupdated(CommonUtils.getCurrentDate());
			loginDO.setRole("Owner");
			loginDO.setStatus("IA");
			loginDO.setAuditid(auditid);
			System.out.println("Suresh: loginDO="+loginDO);
			facilityDemographicsDAO.saveLoginInfo(loginDO);
			
			//Insert Transaction services
	        ArrayList<String> serviceList = facilityDemographicsDO.getServices();
	        for(String serviceName: serviceList) {
	        	String serviceid = facilityDemographicsDAO.getServiceId(serviceName);
	        	TransactionServicesDO serviceDO = new TransactionServicesDO();
	        	serviceDO.setFacilityid(facilityid);
		        serviceDO.setPolicyid(policyid);
		        serviceDO.setTermid(termid);
		        serviceDO.setTransactionseqnbr(transactionseqnbr);
		        serviceDO.setServiceid(serviceid);
		        serviceDO.setServiceseqnbr(1);
		        serviceDO.setServicesubplantype(1);
		        serviceDO.setStatus("IA");
		        serviceDO.setServiceeffectivedate(CommonUtils.getCurrentDate());
		        serviceDO.setServiceenddate(CommonUtils.getCurrentDate());
		        serviceDO.setServiceoriginalamt(10000);
		        serviceDO.setServicediscountcode(123);
		        serviceDO.setServicediscountamt(100);
		        serviceDO.setServicefinalamt(110000);
		        
		        System.out.println("Suresh: serviceDO="+serviceDO);
		        
		        facilityDemographicsDAO.saveServiceInfo(serviceDO);
	        }
	        
	      //Insert audit records
			AuditDO auditDO = new AuditDO();
			auditDO.setAuditId(auditid);
			auditDO.setTypeofrequest("Facility Registration by User");
			auditDO.setTransaction("New Facility Registration");
			auditDO.setAdminid("");
			auditDO.setRequestchannel("Web");
			auditDO.setUseragent("Browser");
			auditDO.setFacilityid(facilityid);
			auditDO.setRequestdate(CommonUtils.getCurrentDate());			
			System.out.println("Suresh: auditDO="+auditDO);
			facilityDemographicsDAO.saveAuditInfo(auditDO);
			
	        
			return facilityDemographicsDAO.saveFacilityDemographics(facilityDemographicsDO);
		}
		catch (DAOException exception) {
			throw new ServiceException(exception.getMessage(), exception);
		}
		catch (NullPointerException npe) {
			throw new ServiceException(npe.getMessage(), npe);
		}
		catch (Exception exception) {
			throw new ServiceException(exception.getMessage(), exception);
		}
	}
	
	public FacilityDemographicsDAO getFacilityDemographicsDAO() {
		return facilityDemographicsDAO;
	}

	public void setFacilityDemographicsDAO(
			FacilityDemographicsDAO facilityDemographicsDAO) {
		this.facilityDemographicsDAO = facilityDemographicsDAO;
	}
}
