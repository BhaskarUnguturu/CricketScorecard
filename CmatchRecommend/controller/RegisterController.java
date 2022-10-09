package com.cgi.cmatch.controller;

import java.io.IOException;

import org.hibernate.type.ImageType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cgi.cmatch.entity.Register;
import com.cgi.cmatch.exception.MailSendingException;
import com.cgi.cmatch.exception.RegisterException;
import com.cgi.cmatch.service.RegisterService;
import com.cgi.cmatch.vo.UserVo;

@RestController
@CrossOrigin("*")
@RequestMapping("/cMatch")
public class RegisterController {

	@Autowired
	RegisterService registerService;

	// registering the user
	@PostMapping("/register")
	public ResponseEntity<?> registerUser(@RequestParam("upload") MultipartFile imageFile,
			@RequestParam("username") String username, @RequestParam("password") String password) {
		Register register_Res = null;
	
		UserVo userVo = new UserVo();
		try {
			// setting up thre object details from request param
			userVo.setUserName(username);
			userVo.setUserPassword(password);
			userVo.setImageName(imageFile.getName());
			userVo.setImageType(imageFile.getContentType());

			userVo.setPic(imageFile.getBytes());
			// registering the user
			register_Res = registerService.registerService(userVo);
		} catch (IOException e) {
			return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (RegisterException re) {
			return new ResponseEntity<>(re, HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (Exception e) {
			return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(register_Res, HttpStatus.CREATED);

	}

}