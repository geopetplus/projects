package com.geopetplusadmin.exception;

/**
 * Handling service layer exceptions 
 * 
 * @author Nagarjuna Goud Tummala
 *
 */
public class ServiceException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * Default Constructor
	 */
	public ServiceException() {
		super();
	}
	
	/**
	 * 
	 * @param message
	 */
	public ServiceException(String message) {
		super(message);
	}
	
	/**
	 * 
	 * @param cause
	 */
	public ServiceException(Throwable cause) {
		super(cause);
	}	
	
	/**
	 * 
	 * @param message
	 * @param cause
	 */
	public ServiceException(String message, Throwable cause) {
		super(message, cause);
	}
}
