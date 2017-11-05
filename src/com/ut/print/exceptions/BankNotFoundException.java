package com.ut.print.exceptions;

public class BankNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BankNotFoundException(String error) {
		super(error);
	}

}
