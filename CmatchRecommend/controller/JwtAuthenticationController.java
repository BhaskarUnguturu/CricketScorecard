package com.cgi.cmatch.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cgi.cmatch.entity.Register;
import com.cgi.cmatch.repository.RegisterRepository;
import com.cgi.cmatch.service.GetRegisteredUserDetailsService;
import com.cgi.cmatch.service.JwtUserDetailsService;
import com.cgi.cmatch.util.JwtTokenUtil;
import com.cgi.cmatch.vo.LoginVo;

@RestController
@CrossOrigin(origins = "*")
public class JwtAuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	BCryptPasswordEncoder encoder;

	@Autowired
	RegisterRepository registerRepo;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private JwtUserDetailsService userDetailsService;

	@Autowired
	GetRegisteredUserDetailsService getDetailsServiceForLoggedinInUser;

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody Register authenticationRequest) throws Exception {
		//will check whether the username and [password is correct or not
		authenticate(authenticationRequest.getcMatchUserName(), authenticationRequest.getcMatchPassword());
		//getting the userdetails   from reg table by userame but userdetails consist only username,password
		final UserDetails userDetails = userDetailsService
				.loadUserByUsername(authenticationRequest.getcMatchUserName());
		//after getting the username making a token using the username itself
		final String token = jwtTokenUtil.generateToken(userDetails);
		//calling another service to get all the data using that username therby saving it in an
		//register object
		Register register = getDetailsServiceForLoggedinInUser.getRegisteredDetailsService(authenticationRequest);
		//login vo will be used to send the required data vo satnds for visual objects which interacts with the ui 
		LoginVo loginVo = new LoginVo();
		loginVo.setUsername(register.getcMatchUserName());
		loginVo.setPassword(register.getcMatchPassword());
		loginVo.setImagetype(register.getcMatchImageType());
		loginVo.setImageName(register.getcMatchImageName());
		loginVo.setImagePic(register.getcMatchImage());
		//setting ht egenerated token to vo object
		loginVo.setToken(token);
		// loginVo.setToken(token);
		// authenticationRequest.setToken(token);
		//returning the required data back to angular
		return new ResponseEntity<>(loginVo, HttpStatus.OK);
	}

	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
}
