package com.geopetplusadmin.service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Calendar;

import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

import com.geopetplusadmin.domain.utility.CommonUtils;
import com.geopetplusadmin.domain.utility.TranformationUtils;
import com.geopetplusadmin.exception.DAOException;
import com.geopetplusadmin.exception.ServiceException;
import com.geopetplusadmin.hibernate.admin.AuditDO;
import com.geopetplusadmin.hibernate.admin.FacilityDemographicsDO;
import com.geopetplusadmin.hibernate.admin.FacilityTermDO;
import com.geopetplusadmin.hibernate.admin.LoginDO;
import com.geopetplusadmin.hibernate.admin.TransactionServicesDO;
import com.geopetplusadmin.hibernate.admin.TransactionSummaryDO;
import com.geopetplusadmin.model.FacilityDemographicsDAO;
import com.geopetplusadmin.model.FacilityDemographicsDAOImpl;
import com.geopetplusadmin.vo.FacilityDemographicsVO;

public class FacilityDemographicsServiceImpl implements FacilityDemographicsService {
	
	private final static Logger LOGGER = Logger.getLogger(FacilityDemographicsServiceImpl.class);
	
	FacilityDemographicsDAO facilityDemographicsDAO;
	
	@Transactional(readOnly = false)
	public void saveFacilityDemographics(FacilityDemographicsVO facilityDemographicsVO) throws ServiceException {
		
		try {
			LOGGER.info("Start storing Facility Demographics");
			FacilityDemographicsDO facilityDemographicsDO = TranformationUtils.transformFacilityDemographicsVO(facilityDemographicsVO);
			String facilityid = CommonUtils.generateFacilityId(facilityDemographicsDO.getFacilityname());
			BigInteger facilityseq = facilityDemographicsDAO.getSequence("facilityseq");
			facilityseq = facilityseq.add(BigInteger.ONE);
			facilityid = facilityid.concat(facilityseq.toString());
			LOGGER.info("New Facility ID created "+facilityid);
			
			String policyid = "PL".concat(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
			BigInteger policyseq = facilityDemographicsDAO.getSequence("policyseq");
			policyseq = policyseq.add(BigInteger.ONE);
			policyid = policyid.concat(policyseq.toString());
			LOGGER.info("New Policy# "+policyid+" created for "+facilityid);
			
			String transactionseqnbr = "TR".concat(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
			BigInteger transseq = facilityDemographicsDAO.getSequence("transseq");
			transseq = transseq.add(BigInteger.ONE);
			transactionseqnbr = transactionseqnbr.concat(transseq.toString());
			LOGGER.info("New Transaction Sequence# "+transactionseqnbr+" created for "+facilityid+", Policy# "+policyid);
			
			String auditid = "AUD".concat(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
			BigInteger auditseq = facilityDemographicsDAO.getSequence("auditseq");
			auditseq = auditseq.add(BigInteger.ONE);
			auditid = auditid.concat(auditseq.toString());
			LOGGER.info("New Audit# "+auditid+" created for "+facilityid+", Policy# "+policyid);
			
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
			facilityDemographicsDO.setAuditID(auditid);
			facilityDemographicsDAO.saveFacilityDemographics(facilityDemographicsDO);
			LOGGER.info("Successfully saved facility demographics for "+facilityid+", Policy# "+policyid);
			
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
			facilityDemographicsDAO.saveLoginInfo(loginDO);
			LOGGER.info("Successfully created login account for "+facilityid+", Policy# "+policyid);
			
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
		        serviceDO.setServiceseqnbr("S1");
		        serviceDO.setServicesubplantype("");
		        serviceDO.setStatus("IA");
		        serviceDO.setServiceeffectivedate(CommonUtils.getCurrentDate());
		        serviceDO.setServiceenddate(CommonUtils.getCurrentDate());
		        serviceDO.setServiceoriginalamt(0);
		        serviceDO.setServicediscountcode(null);
		        serviceDO.setServicediscountamt(0);
		        serviceDO.setServicefinalamt(0);
		        facilityDemographicsDAO.saveServiceInfo(serviceDO);
		        LOGGER.info("Successfully saved facility service "+serviceName+" for "+facilityid+", Policy# "+policyid);
	        }
	        
	       //Insert FacilityTerms
	        ArrayList<String> facilityTermList = facilityDemographicsDO.getServices();
	        for(String serviceName: serviceList) {
	        	String serviceid = facilityDemographicsDAO.getServiceId(serviceName);
	        	FacilityTermDO facilityTermDO = new FacilityTermDO();
	        	facilityTermDO.setFacilityid(facilityid);
	        	facilityTermDO.setPolicyid(policyid);
	        	facilityTermDO.setTermid(termid);
	        	facilityTermDO.setTransactionseqnbr(transactionseqnbr);
	        	facilityTermDO.setStatus("IA");
	        	facilityTermDO.setTermeffectivedate(CommonUtils.getCurrentDate());
	        	facilityTermDO.setTermenddate(CommonUtils.getCurrentDate());
	        	facilityTermDO.setAutorenewind("N");
		        facilityDemographicsDAO.saveFacilityTermInfo(facilityTermDO);
		        LOGGER.info("Successfully saved facility term "+termid+" for Service "+serviceName+", Facility "+facilityid+", Policy# "+policyid);
	        }
	        
	      //Insert FacilitySummary
	        	TransactionSummaryDO transactionSummaryDO = new TransactionSummaryDO();
	        	transactionSummaryDO.setTransactionseqnr(transactionseqnbr);
	        	transactionSummaryDO.setTransactiondate(CommonUtils.getCurrentDate());
	        	transactionSummaryDO.setTermamountbeforediscount(0);
	        	transactionSummaryDO.setServicetotdiscountamt(0);
	        	transactionSummaryDO.setDiscountcode("");
	        	transactionSummaryDO.setDiscountamt(0);
	        	transactionSummaryDO.setTermamountafterdiscount(0);
	        	transactionSummaryDO.setPrevioustermamount(0);
	        	transactionSummaryDO.setFinaltransactionamountdebit(0);
	        	transactionSummaryDO.setFinaltransactionamountcredit(0);
	        	transactionSummaryDO.setModeofpayment("");
	        	transactionSummaryDO.setPaymentstatus("");
	        	transactionSummaryDO.setAuditid(auditid);
	        	transactionSummaryDO.setRemarks("");
		        facilityDemographicsDAO.saveTransactionSummaryInfo(transactionSummaryDO);
		        LOGGER.info("Successfully saved facility transaction# "+transactionseqnbr+" for "+facilityid+", Policy# "+policyid);
	        
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
				facilityDemographicsDAO.saveAuditInfo(auditDO);
				LOGGER.info("Successfully saved audit# "+auditid+" for "+facilityid+", Policy# "+policyid);
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
