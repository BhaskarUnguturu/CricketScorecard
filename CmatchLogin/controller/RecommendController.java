package com.cgi.cmatch.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cgi.cmatch.entity.OldMatchRecommend;
import com.cgi.cmatch.repository.RecommendRepository;
import com.cgi.cmatch.service.RecommendService;

 

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class RecommendController {

	@Autowired
	RecommendRepository repository;
	
	@Autowired
	private RecommendService  recommendService; 
	
	public RecommendController(RecommendService  recommendService)
	{
		this.recommendService=recommendService;
	}
	
	 @PostMapping("/addrecommend/create")
	 public ResponseEntity<?> addRecommend(@RequestBody OldMatchRecommend recommend)
	 {
		
			recommendService.addRecommend(recommend);
			return new ResponseEntity<String>("Recommend Added Successfully",HttpStatus.CREATED);
		
	 }
	 
	
	
		
	@DeleteMapping("/deleterecommend/{id}")
	 public  ResponseEntity<?> deleteRecommend(@PathVariable("id") String id)
		{
			
				recommendService.deleteRecommend(id);
				return new ResponseEntity<String>("Recommend deleted",HttpStatus.OK);
		}
	 
	 
	 
	 @GetMapping("/getallrecommends/{email}")
	  public ResponseEntity<?> getAllRecommends(@PathVariable String email)
	  {
		 System.out.println("hi");
		   OldMatchRecommend[] data=recommendService.getAllRecommends(email);
		   return new ResponseEntity<OldMatchRecommend[]>(data,HttpStatus.OK);
				
	  }
	 
	 

	/*@GetMapping("/recommends")
	public List<OldMatchRecommend> getAllRecommends() {
		List<OldMatchRecommend> recommend = new ArrayList<>();
		repository.findAll().forEach(recommend::add);
		return recommend;
	}*/

	
	
	
	@PostMapping("/recommend/create")
	public OldMatchRecommend postRecommend(@RequestBody OldMatchRecommend recommend) {
		 OldMatchRecommend _recommend = repository.save(recommend);
		   return _recommend;
	}
	


	
	@DeleteMapping("/recommend/{id}")
	public String deleteRecommendbyunique_id(@PathVariable("id") String id) {
		
		repository.deleteById(id);
		return "deleted";
	}
	
	
	@GetMapping("/recommends/{email}")
	public OldMatchRecommend[] getAllRecommendstitle(@PathVariable("email") String email) {
	OldMatchRecommend[] recommend= repository.findByEmail(email);
	return recommend;
	}
	
	
	
	
	
	
	
}
