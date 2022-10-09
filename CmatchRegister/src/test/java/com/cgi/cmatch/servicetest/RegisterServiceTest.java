package com.cgi.cmatch.servicetest;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.isA;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import com.cgi.cmatch.entity.Register;
import com.cgi.cmatch.exception.DuplicateRegistrationException;
import com.cgi.cmatch.exception.MailSendingException;
import com.cgi.cmatch.exception.RegisterException;
import com.cgi.cmatch.repository.RegisterRepository;
import com.cgi.cmatch.service.RegisterService;
import com.cgi.cmatch.util.SimpleMailer;
import com.cgi.cmatch.vo.UserVo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RegisterServiceTest {

	@Autowired
	RegisterService regService;

	@Autowired
	BCryptPasswordEncoder encoder;

	@Autowired
	SimpleMailer simpleMailer;

	@MockBean
	RegisterRepository registerRepository;

	@Test(expected = DuplicateRegistrationException.class)
	public void Test1() throws RegisterException, DuplicateRegistrationException, Exception {
		byte[] arr = new byte[] {};
		UserVo userVo = new UserVo();
		userVo.setId(1);
		userVo.setImageName("helo");
		userVo.setImageType("image");
		userVo.setPic(arr);
		userVo.setUserName("abc");
		userVo.setUserPassword("abc");

		Register register = new Register();
		register.setcMatchImage(arr);
		register.setcMatchImageName("helo");
		register.setcMatchImageType("image");
		register.setcMatchPassword("abcd");
		register.setcMatchRegId(1);
		register.setcMatchUserName("abc");

		when(registerRepository.getUserDetails(Mockito.anyString())).thenReturn(register);
		when(registerRepository.save(register)).thenReturn(register);
		assertThat(regService.registerService(userVo), isA(Register.class));

	}

// for checking mail id not present
	@Test
	public void Test2() {
		Register register = new Register();
// register.setcMatchImage(arr);
		register.setcMatchImageName("helo");
		register.setcMatchImageType("image");
		register.setcMatchPassword("abcd");
		register.setcMatchRegId(1);
		register.setcMatchUserName("abcd");

		when(registerRepository.getUserDetails(Mockito.anyString())).thenReturn(null);

		assertThat(regService.checkMailIdPresent("helo12345"), is(false));

	}

// checking for mail id
	@Test
	public void Test3() {
		Register register = new Register();
// register.setcMatchImage(arr);
		register.setcMatchImageName("helo");
		register.setcMatchImageType("image");
		register.setcMatchPassword("abcd");
		register.setcMatchRegId(1);
		register.setcMatchUserName("abcd");

		when(registerRepository.getUserDetails(Mockito.anyString())).thenReturn(register);

		assertThat(regService.checkMailIdPresent("helo12345"), is(true));

	}

}