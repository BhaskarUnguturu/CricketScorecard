package com.cgi.cmatch.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cgi.cmatch.entity.Register;
import com.cgi.cmatch.exception.CheckPasswordException;
import com.cgi.cmatch.exception.ForgetPasswordException;
//service for change password
@Service
public interface ForgoetPasswordInterface {

	public boolean changePassword(Register register) throws ForgetPasswordException;
	public Register checkPassword(Register register) throws CheckPasswordException;
}
