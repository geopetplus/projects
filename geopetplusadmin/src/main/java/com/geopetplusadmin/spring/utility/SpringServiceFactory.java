package com.geopetplusadmin.spring.utility;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringServiceFactory {
	
	private static ApplicationContext SPRING_CONTEXT = null;
	
	public static Object getBean(String beanName) throws Exception {
		Object beanService = null;
		if (SPRING_CONTEXT == null) {
			SPRING_CONTEXT = new ClassPathXmlApplicationContext("classpath*:**/spring.xml");
		}
		if (SPRING_CONTEXT != null 
				&& beanName != null) {
			beanService = (Object) SPRING_CONTEXT.getBean(beanName);
		}
		return beanService;
	}

}
