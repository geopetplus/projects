package com.geopetplusadmin.exception;

/**
 * Handling delegate layer exceptions 
 * 
 * @author Nagarjuna Goud Tummala
 *
 */
public class DelegateException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * Default Constructor
	 */
	public DelegateException() {
		super();
	}
	
	/**
	 * 
	 * @param message
	 */
	public DelegateException(String message) {
		super(message);
	}
	
	/**
	 * 
	 * @param cause
	 */
	public DelegateException(Throwable cause) {
		super(cause);
	}	
	
	/**
	 * 
	 * @param message
	 * @param cause
	 */
	public DelegateException(String message, Throwable cause) {
		super(message, cause);
	}
}
