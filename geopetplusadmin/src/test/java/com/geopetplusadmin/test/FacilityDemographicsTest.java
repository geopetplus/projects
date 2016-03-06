package com.geopetplusadmin.test;

import org.junit.Ignore;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.geopetplusadmin.model.FacilityDemographicsDAO;
import com.geopetplusadmin.model.FacilityDemographicsDAOImpl;
import com.geopetplusadmin.service.FacilityDemographicsService;

@Ignore
public class FacilityDemographicsTest {

	public static void main(String[] args) throws Exception {
		
		FacilityDemographicsDAO facilityDemographicsDAO = new FacilityDemographicsDAOImpl();
		
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath*:**/spring.xml");
		FacilityDemographicsService service = (FacilityDemographicsService) context.getBean("facilityDemographicService");

		/*FacilityDemographicsVO facilityDemographicsVO = new FacilityDemographicsVO();
		FacilityDemographicsDO facilityDemographicsDO = TranformationUtils.transformFacilityDemographicsVO(facilityDemographicsVO);
		String status = service.insertDemographics(facilityDemographicsDO);
		System.out.println("Status="+status);*/
		
		//String s = service.insertDemographics();
		//System.out.println("Completed with status="+s.toString());
		
	}
}
