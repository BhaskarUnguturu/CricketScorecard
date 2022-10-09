package com.cgi.cmatch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgi.cmatch.entity.Register;
import com.cgi.cmatch.repository.RegisterRepository;
 

@Service
public class GetRegisteredUserDetailsService {
	
	
	
	@Autowired
	RegisterRepository registerRepo;
	public Register getRegisteredDetailsService(Register loggedInUser) {
		return registerRepo.getUsernameAndPassword(loggedInUser.getcMatchUserName());
		
	}

}
