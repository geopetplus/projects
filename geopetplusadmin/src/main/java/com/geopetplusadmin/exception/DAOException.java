package com.geopetplusadmin.exception;

/**
 * Handling DAO layer exceptions 
 * 
 * @author Nagarjuna Goud Tummala
 *
 */
public class DAOException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * Default Constructor
	 */
	public DAOException() {
		super();
	}
	
	/**
	 * 
	 * @param message
	 */
	public DAOException(String message) {
		super(message);
	}
	
	/**
	 * 
	 * @param cause
	 */
	public DAOException(Throwable cause) {
		super(cause);
	}	
	
	/**
	 * 
	 * @param message
	 * @param cause
	 */
	public DAOException(String message, Throwable cause) {
		super(message, cause);
	}
}
