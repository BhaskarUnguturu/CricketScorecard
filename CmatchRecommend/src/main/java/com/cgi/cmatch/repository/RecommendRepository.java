package com.cgi.cmatch.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cgi.cmatch.entity.OldMatchRecommend;
 
@Repository
public interface RecommendRepository extends MongoRepository<OldMatchRecommend, String>{

	//List<Recommend> findByTitle(String title);
	//void deleteByTitle(String title);
	OldMatchRecommend[] findAllRecommendByEmail(String email);
	OldMatchRecommend[] findByEmail(String email);
	//Boolean existsByUnique_id(String unique_id);
	
}
