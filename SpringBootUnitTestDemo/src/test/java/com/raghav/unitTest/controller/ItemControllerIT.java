package com.raghav.unitTest.controller;

import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.raghav.unitTest.data.ItemRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ItemControllerIT {

	@Autowired
	private TestRestTemplate restTemplate;
	/*
	 * 
	 * Mocking ItemRepository as we don't want to talk with real database
	 * 
	 */
	@MockBean
	private ItemRepository itemRepository;
	
	@Test
	public void contextLoads() throws JSONException{
		String response = restTemplate.getForObject("/all-items-from-database", String.class);
		JSONAssert.assertEquals("[{1001},{1002},{1003}]", response, false);
	}
}
