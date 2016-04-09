package com.hcl.exception;

public class DelegateException extends Exception {

	private static final long serialVersionUID = 1L;

	public DelegateException() {
		super();
	}
	
	public DelegateException(String message) {
		super(message);
	}
	
	public DelegateException(Throwable cause) {
		super(cause);
	}	
	
	public DelegateException(String message, Throwable cause) {
		super(message, cause);
	}
}
