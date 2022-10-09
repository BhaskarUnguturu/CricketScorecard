package com.cgi.cmatch.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cgi.cmatch.entity.NewMatchRecommend;
import com.cgi.cmatch.entity.OldMatchRecommend;

 

public interface NewMatchRepository extends MongoRepository<NewMatchRecommend, String> {

	NewMatchRecommend[] findByEmail(String email);
}
