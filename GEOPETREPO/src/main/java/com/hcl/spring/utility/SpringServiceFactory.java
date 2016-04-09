package com.hcl.spring.utility;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringServiceFactory {
	
	private final static Logger LOGGER = Logger.getLogger(SpringServiceFactory.class);
	
	private static ApplicationContext SPRING_CONTEXT = null;
	
	public static Object getBean(String beanName) throws Exception {
		
		LOGGER.info("Invoked SpringServiceFactory.java # getBean(String) method");
		
		Object beanService = null;
		
		if (SPRING_CONTEXT == null) {
			
			SPRING_CONTEXT = new ClassPathXmlApplicationContext("classpath*:**/spring.xml");
		}
		
		if (SPRING_CONTEXT != null 
				&& beanName != null) {
			
			beanService = (Object) SPRING_CONTEXT.getBean(beanName);
		}
		
		LOGGER.info("Exited SpringServiceFactory.java # getBean(String) method");
		
		return beanService;
	}

}
