package com.geopetplusadmin.test;

import org.junit.Ignore;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Ignore
public class FullTest {

	public static void main(String[] args) throws Exception {

		ApplicationContext context = new ClassPathXmlApplicationContext("classpath*:**/spring.xml");
		
		/*LoginService loginService = (LoginService) context.getBean("loginService");
		String facilityId = loginService.insertLogin();
		
		FacilityDemographicsService facilityDemographicsService = (FacilityDemographicsService) context.getBean("facilityDemographicService");
		String status = facilityDemographicsService.insertDemographics(facilityId);
		
		AudithistoryService audithistoryService = (AudithistoryService) context.getBean("audithistoryService");
		status = audithistoryService.insertAudit(facilityId);
		
		System.out.println("Completed with status="+status.toString());*/
		
	}
}
