package com.geopetplusadmin.test;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.geopetplusadmin.service.LoginService;
import com.geopetplusadmin.vo.LoginVO;

@Ignore
@ContextConfiguration( locations = {"classpath*:**/spring.xml"} )
public class LoginTest extends AbstractJUnit4SpringContextTests {
	
	@Autowired
	private LoginService loginService;
	
	@Test
	public void testinsertLogin() throws Exception {
		
		LoginVO loginvo = new LoginVO();
		assertNotNull(loginvo);
		
	}
	
}
