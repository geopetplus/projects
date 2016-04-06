package com.geopetplusadmin.security;

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

/**
 * 
 * @author Nagarjuna Goud Tummala
 *
 */
public class SecurityFilter implements Filter {
	
	private final static Logger LOGGER = Logger.getLogger(SecurityFilter.class);

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
	}
	
	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
			FilterChain filterChain) throws IOException, ServletException {
		
		LOGGER.debug("Invoked SecurityFilter.java # doFilter(ServletRequest, ServletResponse, FilterChain) method");
		
		HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        
        // Created the user session
        HttpSession session = request.getSession(true);
        
        String currentPageUrl = request.getRequestURL().toString();
        
        LOGGER.debug("Current Requested Page URL: " + currentPageUrl);
        
        // Processing the request
        filterChain.doFilter(request, response);
        
        LOGGER.debug("Exited SecurityFilter.java # doFilter(ServletRequest, ServletResponse, FilterChain) method");
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}

}
