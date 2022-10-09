package com.cgi.cmatch.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgi.cmatch.entity.OldMatchRecommend;
import com.cgi.cmatch.repository.RecommendRepository;
//this is the service method it uses the interface class i,e Recommend service 
@Service
public class RecommendServiceImpl  implements RecommendService{
	
	@Autowired
	private RecommendRepository Recommendrepository;
	
	
	public RecommendServiceImpl(RecommendRepository recommendRepository)
	{
		this.Recommendrepository=recommendRepository;
	}
	
	
	//  this method is used to addRecommend
	@Override
	  public OldMatchRecommend addRecommend(OldMatchRecommend recommend) {
	  
	  
	  return Recommendrepository.insert(recommend);
	  }
	  
	
	// this method is used to getallRecommends
	@Override
	  public OldMatchRecommend[] getAllRecommends(String email) {
		 System.out.println(email);
		 OldMatchRecommend[] abc=Recommendrepository.findAllRecommendByEmail(email);
		 System.out.println(abc.toString());
		 return Recommendrepository.findAllRecommendByEmail(email);
	 
	  }
	
	
	// this method is used to delete Recommend
	@Override
	  public void deleteRecommend(String recommendId) {
	  
	  Recommendrepository.deleteById(recommendId); }
	 
}
