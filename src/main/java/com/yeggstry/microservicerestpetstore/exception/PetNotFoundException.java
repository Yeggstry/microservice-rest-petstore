package com.yeggstry.microservicerestpetstore.exception;

public class PetNotFoundException extends RuntimeException {

	/**
	 * Generated serial version UID
	 */
	private static final long serialVersionUID = -6375657117849600473L;

	public PetNotFoundException(String message) {
		super(message);
	}
}
