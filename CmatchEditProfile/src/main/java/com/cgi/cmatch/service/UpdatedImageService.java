package com.cgi.cmatch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgi.cmatch.entity.Register;
import com.cgi.cmatch.repository.RegisterRepository;
import com.cgi.cmatch.vo.UserVo;
//update image Service the method is to update the old image the given by user at register time
@Service
public class UpdatedImageService  implements UpdatedImageServiceInterface{
//using the register repository it contains the jpaRepository
	@Autowired
	RegisterRepository updateImageRepo;
	
	//this method is to update the old image in the user
	@Override
	public Register updateImage(UserVo userVo) {
		Register register=new Register();
		register.setcMatchUserName(userVo.getUserName());
		register=updateImageRepo.getUserDetails(register.getcMatchUserName());
		register.setcMatchImageName(userVo.getImageName());
		register.setcMatchImageType(userVo.getImageType());
		register.setcMatchImage(userVo.getPic());
		updateImageRepo.save(register);
		return register;
		
		
	}

}
