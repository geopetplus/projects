package com.geopetplusadmin.test;

import static org.junit.Assert.assertNotNull;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.geopetplusadmin.domain.utility.TranformationUtils;
import com.geopetplusadmin.hibernate.admin.FacilityDemographicsDO;
import com.geopetplusadmin.service.FacilityDemographicsService;
import com.geopetplusadmin.vo.FacilityDemographicsVO;

@Ignore
@ContextConfiguration( locations = {"classpath*:**/spring.xml"} )
public class FacilityDemographicsTest {
	
	@Autowired
	private FacilityDemographicsService facilityDemographicService;
	
	private static FacilityDemographicsVO facilityDemographicsVO;
	private static Date currentDate = new Date();
	private Calendar currentCal = new GregorianCalendar();
	
	@Test
	public void FacilityDemographicsDataTest() throws Exception {
		
		facilityDemographicsVO = new FacilityDemographicsVO();
		facilityDemographicsVO.setFacilityid("facilityid");
		facilityDemographicsVO.setFacilityname("facilityname");
		facilityDemographicsVO.setMailAddr1("mailAddr1");
		facilityDemographicsVO.setMailAddr2("mailAddr2");
		facilityDemographicsVO.setMailingCity("mailingCity");
		facilityDemographicsVO.setMailingLocation("Location");
		facilityDemographicsVO.setMailingState("st");
		facilityDemographicsVO.setMailingPincode("111111");
		facilityDemographicsVO.setSameAddress(true);
		facilityDemographicsVO.setBillAddr1("billAddr1");
		facilityDemographicsVO.setBillAddr2("billAddr2");
		facilityDemographicsVO.setBillCity("billCity");
		facilityDemographicsVO.setBillLocation("Location");
		facilityDemographicsVO.setBillPincode("pin");
		facilityDemographicsVO.setBillState("st1");
		facilityDemographicsVO.setContactFirstName("fname");
		facilityDemographicsVO.setContactLastName("lname");
		facilityDemographicsVO.setAuditID("auditID");
		facilityDemographicsVO.setFacilityAltPhone("AltPhone");
		facilityDemographicsVO.setFacilityEmail1("mail1");
		facilityDemographicsVO.setFacilityEmail2("mail2");
		facilityDemographicsVO.setFacilityPhone("Phone");
		facilityDemographicsVO.setFacilityRegEndDate(currentDate);
		facilityDemographicsVO.setFacilityRegStartDate(currentDate);
		facilityDemographicsVO.setFacilityURL("facilityURL");
		facilityDemographicsVO.setFacilityWhatsAppNum("WhatsApp");
		facilityDemographicsVO.setFacilyMobileNum("MobileNum");
		facilityDemographicsVO.setLastUpdateDate(currentDate);
		facilityDemographicsVO.setStatus("IA");
		facilityDemographicsVO.setVersionid("V1");
		
		FacilityDemographicsDO facilityDemographicsDO = TranformationUtils.transformFacilityDemographicsVO(facilityDemographicsVO);
		assertNotNull(facilityDemographicsDO);
	}

	public FacilityDemographicsVO getFacilityDemographicsVO() {
		return facilityDemographicsVO;
	}

	public void setFacilityDemographicsVO(FacilityDemographicsVO facilityDemographicsVO) {
		this.facilityDemographicsVO = facilityDemographicsVO;
	}
}
