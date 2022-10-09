package com.cgi.cmatch.servicetest;
import java.util.Optional;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.cgi.cmatch.entity.OldMatchRecommend;
import com.cgi.cmatch.repository.RecommendRepository;
import com.cgi.cmatch.service.RecommendServiceImpl;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
@RunWith(MockitoJUnitRunner.class)

public class RecommendServiceImplTest {
	@Mock
	private RecommendRepository recommendrepo;

	// FavouriteServiceImpl service is created to get,add,delete the book selected as favourite by the user

	@InjectMocks
	private RecommendServiceImpl favouriteservice;

	OldMatchRecommend favourite;

	Optional<OldMatchRecommend> optBook;

	@Before
	public void setUp() throws Exception {
	favourite = new OldMatchRecommend("1","petee@gmail.com", "12345", "bhaskar", "admin@a.a");
	optBook = Optional.of(favourite);
	}

	@After
	public void tearDown() throws Exception {
	}
	@Test
	public void contextLoads() {
	}
	
	/*@Test
	public void addRecommend() {
		
	           when(RecommendRepository.save((OldMatchRecommend) any())).thenReturn(favourite);
	           User userSaved = userService.addUser(user);
	           assertEquals(user, userSaved);

	}*/
	}

