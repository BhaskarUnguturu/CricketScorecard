package com.cgi.cmatch.servicetest;



import static org.hamcrest.CoreMatchers.isA;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cgi.cmatch.entity.Register;
import com.cgi.cmatch.repository.RegisterRepository;
import com.cgi.cmatch.service.UpdatedImageService;
import com.cgi.cmatch.vo.UserVo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UpdateImageTest {

	@Autowired
	UpdatedImageService imageService;
	@MockBean
	RegisterRepository registerRepository;

	@Test
	public void Test1() {
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
		register.setcMatchPassword("abc");
		register.setcMatchRegId(1);
		register.setcMatchUserName("abc");

		when(registerRepository.getUserDetails(Mockito.anyString())).thenReturn(register);
		assertThat(imageService.updateImage(userVo), isA(Register.class));
	}

}