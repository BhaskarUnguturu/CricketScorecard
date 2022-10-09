package com.cgi.cmatch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cgi.cmatch.entity.Register;
//for change password this repo we are using 
@Repository
public interface ForgetPasswordRepository extends JpaRepository<Register, Integer>{
	
	@Query(value = "Select * from register where  reg_username=?2 ",nativeQuery = true)
	public Register getUserDetail(String username);

}
