package com.cgi.cmatch.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cgi.cmatch.entity.Register;
import com.cgi.cmatch.service.UpdatedImageService;
import com.cgi.cmatch.vo.UserVo;

/**
 * 
 * @author swetha
 *
 */

@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*")
@RequestMapping("/cMatch")
public class ImageUpdateController {

	@Autowired
	UpdatedImageService imageService;
	@PostMapping("/updateProfilePic")
	//sending username and profile pic from frontend and setting new image and saving
	public ResponseEntity<?> updateImage(@RequestParam("image") MultipartFile imageFile,
			@RequestParam("username") String username) {

		UserVo userVo = new UserVo();
		try {
			userVo.setUserName(username);
			userVo.setImageName(imageFile.getName());
			userVo.setImageType(imageFile.getContentType());
			userVo.setPic(imageFile.getBytes());

			return new ResponseEntity<>(imageService.updateImage(userVo), HttpStatus.OK);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

	}
}
