package com.cgi.cmatch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.User;

import com.cgi.cmatch.entity.Register;
 

public interface RegisterRepository extends JpaRepository<Register, Integer>{
	
	@Query(value = "select * from register where reg_username=?1 ",nativeQuery = true)
	public Register getUserDetails(String username);
	//two same query written will change later
	@Query(value = "select * from register where reg_username=?1  ",nativeQuery = true)
	public Register getUsernameAndPassword(String username);

}
