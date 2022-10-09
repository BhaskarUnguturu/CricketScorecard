package com.cgi.cmatch.service;

import com.cgi.cmatch.entity.OldMatchRecommend;

import java.util.List;

import org.springframework.stereotype.Service;
//this is the service method it contains the 3 methods that is addrecommend ,
//delete recommend,get allrecommend;
@Service
public interface RecommendService {
	
	
	public OldMatchRecommend addRecommend(OldMatchRecommend recommend); 
	public void deleteRecommend( String id); 
	public OldMatchRecommend[] getAllRecommends(String email);

}
