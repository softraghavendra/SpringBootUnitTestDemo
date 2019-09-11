package com.raghav.unitTest.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import static org.mockito.Mockito.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.raghav.unitTest.business.ItemBusinessService;
import com.raghav.unitTest.model.Item;

@RunWith(SpringRunner.class)
@WebMvcTest(ItemController.class)
public class ItemControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ItemBusinessService itemBusinessService;
	
	@Test
	public void dummyItem_basic() throws Exception{ 
		RequestBuilder request = MockMvcRequestBuilders.get("/dummy-item").accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(request)
									.andExpect(status().isOk())
									.andExpect(content().json("{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}"))
									.andReturn();
		
		//public ResultMatcher json(final String jsonContent, final boolean strict)
		// JSONAssert is an awesome framework for making awesome capabilities for unit testing
		// JSONAssert.assertEquals(expected, actual, false)
		// false means we are not stricting our response
		
	}
	
	@Test
	public void itemFromBusinessService_basic() throws Exception{ 
		
		when(itemBusinessService.retrieveHardCodedItem()).thenReturn(new Item(2, "Item2", 10, 100));
		
		RequestBuilder request = MockMvcRequestBuilders.get("/item-from-business-service").accept(MediaType.APPLICATION_JSON);
	
		// remember .json() method is case-sensitive and ignore white spaces.
		MvcResult result = mockMvc.perform(request)
									.andExpect(status().isOk())
									.andExpect(content().json("{id:2, name:Item2, price:10}"))
									.andReturn();
	}
	
	@Test
	public void retrieveAllItemsFromBusinessService_basic() throws Exception{ 
		
		when(itemBusinessService.retrieveAllItems()).thenReturn(
				Arrays.asList(new Item(2, "Item2", 10, 10),
							new Item(3, "Item3", 20, 20)));
		
		RequestBuilder request = MockMvcRequestBuilders.get("/all-items-from-database").accept(MediaType.APPLICATION_JSON);
		
		// remember .json() method is case-sensitive and ignore white spaces.
		// .json internally uses JSONAssert library
		// .json() method order is not important it's sufficient to add each and all elements even blank
		MvcResult result = mockMvc.perform(request)
									.andExpect(status().isOk())
									//.andExpect(content().json("[{id:2, name:Item2, price:10}, {}]"))// runs fine
									//.andExpect(content().json("[{id:2, name:Item2, price:10}]"))// error got 2 expected 1
									.andExpect(content().json("[{id:2, name:Item2, price:10},{id:3, name:Item3, price:20}]"))
									.andReturn();
	}
	
	
	
}
