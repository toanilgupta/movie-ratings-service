
package com.microservices.ratingsdata.service;

import com.microservices.ratingsdata.jpa.UserJpaRepository;
import com.microservices.ratingsdata.model.UserInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvcBuilder;

@RunWith(SpringRunner.class)
//@WebMvcTest
public class RatingsDataServiceControllerTests {

	//@Autowired
	//MockMvc mockMvc;

	MockMvcBuilder mockMvcBuilder;


	@Mock
	UserInfo userInfo;

	@Mock
	UserJpaRepository userJpaRepository;

	@Test
	public  void test() throws Exception
	{
		String id = "abc";
		Mockito.when(userJpaRepository.findById(id)).thenReturn(userInfo);
	}



}

