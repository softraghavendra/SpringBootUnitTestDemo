package com.raghav.unitTest.controller;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(HelloWorldController.class)
public class HelloWorldControllerTest {

	@Autowired
	MockMvc mockMvc;
	
	/*
	 * We Want To call "/hello-world" method so we need to build an uri as its no normal java method
	 * 
	 *Get application/json in response 
	 * 
	 * verify "hello-world" string
	 */
	
	@Test
	public void helloWorld_basic() throws Exception{
		RequestBuilder request = MockMvcRequestBuilders.get("/hello-world").accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(request)
									.andExpect(status().isOk())
									.andExpect(content().string("hello-world"))
									.andReturn();
		assertEquals("hello-world", result.getResponse().getContentAsString());
		
	}
	
	
}
