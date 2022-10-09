package com.cgi.cmatch.controllertest;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.cgi.cmatch.controller.ForgetPasswordController;
import com.cgi.cmatch.entity.Register;
import com.cgi.cmatch.exception.CheckPasswordException;
import com.cgi.cmatch.service.ForgetPasswordService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.lang.Assert;

@RunWith(MockitoJUnitRunner.Silent.class)
@WebMvcTest(controllers = ForgetPasswordController.class)
public class ForgetPasswordControllerTest {

	private MockMvc mockMvc;

	@Mock
	ForgetPasswordService forgetPasswordService;

	@InjectMocks
	ForgetPasswordController forgetPasswordController;

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(forgetPasswordController).build();

	}

	@Test
	public void Test1() throws CheckPasswordException {
		Register register = new Register();
		register.setcMatchUserName("abc");
		register.setcMatchRegId(1);
		register.setcMatchPassword("hello");
		try {
			when(forgetPasswordService.checkPassword(register)).thenReturn(register);

			mockMvc.perform(post("/cMatch/checkPassword").contentType(MediaType.APPLICATION_JSON)
					.content(asJsonString(register))).andExpect(MockMvcResultMatchers.status().isInternalServerError());
		} catch (Exception e) {

		}
	}

	@Test
	public void loginCheckException() throws Exception {

		Register register = new Register();
		register.setcMatchUserName("chak@ail.c");
		register.setcMatchPassword("rockhound199@");

		try {
			when(forgetPasswordService.checkPassword(register)).thenReturn(register);
			assertEquals(register, forgetPasswordService.checkPassword(register));

			mockMvc.perform(MockMvcRequestBuilders.post("/cMatch/checkPassword")
					.contentType(org.springframework.http.MediaType.APPLICATION_JSON).content(asJsonString(register)))
					.andExpect(MockMvcResultMatchers.status().isInternalServerError());
		} catch (Exception e) {
			throw e;
		}
	}

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (JsonProcessingException e) {
// TODO Auto-generated catch block
			throw new RuntimeException();
		}
	}

}
