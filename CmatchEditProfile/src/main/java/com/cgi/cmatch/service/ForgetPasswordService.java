package com.cgi.cmatch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cgi.cmatch.entity.Register;
import com.cgi.cmatch.exception.CheckPasswordException;
import com.cgi.cmatch.exception.ForgetPasswordException;
import com.cgi.cmatch.repository.ForgetPasswordRepository;
import com.cgi.cmatch.repository.RegisterRepository;
import com.cgi.cmatch.util.WebSecurityConfig;

@Service
public class ForgetPasswordService implements ForgoetPasswordInterface {

	@Autowired
	RegisterRepository forgetPasswordRepo;
	@Autowired
	WebSecurityConfig encoder;
//change password returning true or false
	@Override
	public boolean changePassword(Register register) throws ForgetPasswordException {

		// register.setcMatchPassword(encoder.encoder().encode(register.getcMatchPassword()));

		Register updateRegisterObject = forgetPasswordRepo.getUserDetails(register.getcMatchUserName());

		updateRegisterObject.setcMatchPassword(encoder.encoder().encode(register.getcMatchPassword()));
		forgetPasswordRepo.save(updateRegisterObject);
		// forgetPassworRepo.save(updateRegisterObject);
		System.err.println(updateRegisterObject.getcMatchPassword());
		if (updateRegisterObject != null)
			return true;

		return false;
	}
//method for checkpassword returning register object else null
	@Override
	public Register checkPassword(Register register) throws CheckPasswordException{
		// TODO Auto-generated method stub
		
		Register checkPasswordRegisterObject=forgetPasswordRepo.getUserDetails(register.getcMatchUserName());
		if(encoder.encoder().matches(register.getcMatchPassword(), checkPasswordRegisterObject.getcMatchPassword())) {
			return checkPasswordRegisterObject;
		}
		return null;
		
	}

}
