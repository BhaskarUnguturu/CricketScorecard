package com.cgi.cmatch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cgi.cmatch.entity.Register;
import com.cgi.cmatch.exception.DuplicateRegistrationException;
import com.cgi.cmatch.exception.MailSendingException;
import com.cgi.cmatch.exception.RegisterException;
import com.cgi.cmatch.repository.RegisterRepository;
import com.cgi.cmatch.util.SimpleMailer;
import com.cgi.cmatch.vo.UserVo;

@Service
public class RegisterService implements RegisterServiceInterface {

	@Autowired
	RegisterRepository registerRepo;

	@Autowired
	BCryptPasswordEncoder encoder;

	@Autowired
	SimpleMailer simpleMailer;
	 @Bean
	    public BCryptPasswordEncoder passwordEncoder() {
	        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
	        return bCryptPasswordEncoder;
	    }
	@Override
	public Register registerService(UserVo userVo) throws RegisterException, MailSendingException,DuplicateRegistrationException {
		// returns the same object that i a sending to db

		Register registerToDb = new Register();
		registerToDb.setcMatchUserName(userVo.getUserName());
		registerToDb.setcMatchPassword(encoder.encode(userVo.getUserPassword()));
		registerToDb.setcMatchImageName(userVo.getImageName());
		registerToDb.setcMatchImageType(userVo.getImageType());
		registerToDb.setcMatchImage(userVo.getPic());
		
		if (checkMailIdPresent(userVo.getUserName())) {
			throw new DuplicateRegistrationException("Duplicate mail");
		} else {
			//save method returns the same object i am saving in db
			if (registerRepo.save(registerToDb) != null) {
				simpleMailer.send(registerToDb.getcMatchUserName(), "Cmatch Admin ", " Hi "
					+ registerToDb.getcMatchUserName() + ", " 
						+ " Welocme to the world to cricket Matches Search Made Easy..Hope You enjoy Our Application");
				return registerToDb;
			}
		}
		return null;

	}
	
	public boolean checkMailIdPresent(String username) {
		boolean isPresent = true;
		Register registerMail = registerRepo.getUserDetails(username);
		if (registerMail == null) {
			isPresent = false;
		}
		return isPresent;
	}


}
