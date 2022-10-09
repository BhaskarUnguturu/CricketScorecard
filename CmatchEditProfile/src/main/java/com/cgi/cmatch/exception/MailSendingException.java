package com.cgi.cmatch.exception;
//when register object coming from db if it is null this exception will raise
public class MailSendingException extends RegisterException {

	public MailSendingException(String msg) {
		super(msg);
	}

}
