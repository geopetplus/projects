package com.hcl.security;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

public class SecurityFilter implements Filter {
	
	private final static Logger LOGGER = Logger.getLogger(SecurityFilter.class);

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
	}
	
	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
			FilterChain filterChain) throws IOException, ServletException {
		
		LOGGER.info("Invoked SecurityFilter.java # doFilter(ServletRequest, ServletResponse, FilterChain) method");
		
		HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        
        // Created user session
        HttpSession session = request.getSession(true);
        
        String pageUrl = request.getRequestURL().toString();
        LOGGER.info("Requested URL: " + pageUrl);
        
        // Processing the current request
        filterChain.doFilter(request, response);
        
        LOGGER.info("Exited SecurityFilter.java # doFilter(ServletRequest, ServletResponse, FilterChain) method");
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}

}
