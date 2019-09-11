package com.raghav.unitTest.spike;

import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@WebMvcTest(JSONAssertTest.class)
public class JSONAssertTest {

	String actualResponse = "{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}";
	
	@Test
	public void jsonAssert() throws JSONException{
		

		//public ResultMatcher json(final String jsonContent, final boolean strict)
		
		
		// JSONAssert is an awesome framework for making awesome capabilities for unit testing
		// JSONAssert.assertEquals(expected, actual, false)
		// false means we are not stricting our response
		
		// Exact match is necessary except spaces
		String expectedResponse1 = "{\"id\": 1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}";
		JSONAssert.assertEquals(expectedResponse1, actualResponse, true);
	
		String expectedResponse2 = "{\"id\": 1,\"name\":\"Ball\"}";
		JSONAssert.assertEquals(expectedResponse2, actualResponse, false);
		
		//String expectedResponse3 = "{id:1, name:\"Ball 2\"}"; if name is Ball 2 then \ char is important
		//JSONAssert.assertEquals(expectedResponse3, actualResponse, false);
		
		String expectedResponse3 = "{id:1, name:Ball}";
		JSONAssert.assertEquals(expectedResponse3, actualResponse, false);
	}
}
