package com.cgi.cmatch.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cgi.cmatch.entity.Register;
import com.cgi.cmatch.repository.RegisterRepository;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	RegisterRepository registerRepo;
//here uses the jwt token here method perform the operation is the user is logined sucessfully or not
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Register register = registerRepo.getUserDetails(username);
		if (register != null) {
			return new User(register.getcMatchUserName(), register.getcMatchPassword(), new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}
}
