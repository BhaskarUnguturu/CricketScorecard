package com.cgi.cmatch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cgi.cmatch.entity.Register;
import com.cgi.cmatch.exception.CheckPasswordException;
import com.cgi.cmatch.exception.ForgetPasswordException;
import com.cgi.cmatch.service.ForgetPasswordService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/cMatch")

/**
 * 
 * @author swetha
 *
 */

public class ForgetPasswordController {

	@Autowired
	ForgetPasswordService forgetPasswordService;
//gettting old password setting new password saving new password
	@PutMapping("/updatePassword")
	public ResponseEntity<?> changePassword(@RequestBody Register register) {
		try {
			if (forgetPasswordService.changePassword(register)) {
				return new ResponseEntity<>(register, HttpStatus.OK);
			}

		} catch (ForgetPasswordException e) {
			return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (Exception e) {
			return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(register, HttpStatus.BAD_REQUEST);
	}
//checking old password from register object
	@PostMapping("/checkPassword")
	public ResponseEntity<?> checkPassword(@RequestBody Register register) {
		try {
			if (forgetPasswordService.checkPassword(register) != null) {
				return new ResponseEntity<>(register, HttpStatus.OK);
			}
		} catch (CheckPasswordException e) {
			return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (Exception e) {
			return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
