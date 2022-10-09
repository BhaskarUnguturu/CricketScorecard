package com.cgi.cmatch.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cgi.cmatch.entity.NewMatchRecommend;
import com.cgi.cmatch.entity.OldMatchRecommend;
import com.cgi.cmatch.repository.NewMatchRepository;

 

@CrossOrigin("*")
@RestController
@RequestMapping("/api1")
public class NewMatchController {

	
	@Autowired
	NewMatchRepository repository;

	@GetMapping("/newrecommends")
	public List<NewMatchRecommend> getAllRecommends() {
		List<NewMatchRecommend> recommend = new ArrayList<>();
		repository.findAll().forEach(recommend::add);
		return recommend;
	}

	@PostMapping("/newrecommend/create")
	public NewMatchRecommend postRecommend(@RequestBody NewMatchRecommend recommend) {
		 NewMatchRecommend _recommend = repository.save(recommend);
		  return _recommend;
	}



	
	@DeleteMapping("/newrecommend/{id}")
	public String deleteRecommendbyunique_id(@PathVariable("id") String id) {
		repository.deleteById(id);
		return "deleted";
	}
	@GetMapping("/recommends/{email}")
	public NewMatchRecommend[] getAllRecommendstitle(@PathVariable("email") String email) {
	NewMatchRecommend[] recommend= repository.findByEmail(email);
	return recommend;
	}
	

	
}
