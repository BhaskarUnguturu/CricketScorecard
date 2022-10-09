package com.cgi.cmatch.exception;
//for duplicate register this exception 
public class DuplicateRegistrationException extends RegisterException {
	public DuplicateRegistrationException(String msg) {
		super(msg);
	}
}
