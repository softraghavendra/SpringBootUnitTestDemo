package com.raghav.unitTest.business;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.raghav.unitTest.data.SomeDataService;

// What is static import in java how to use it for own classes ? 
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class SomeBusinessMockTest {
	
	/*SomeBusinessImpl business = new SomeBusinessImpl();
	SomeDataService dataServiceMock = mock(SomeDataService.class);
	
	@Before
	public void before(){
		business.setSomeDataService(dataServiceMock);
	}*/
	
	// InjectMocks is injecting the bean and setting into bean and Mock is mocking the object 
	
	@InjectMocks
	SomeBusinessImpl business;
	
	@Mock
	SomeDataService dataServiceMock;

	@Test
	public void calculateSumUsingDataService_Basic(){
		// using mockito when() method and thenReturn() method 
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{1, 2, 3});
		//business.setSomeDataService(dataServiceMock);
		int actualResult =  business.calculateSumUsingDataService(); 
		assertEquals(6, actualResult);
	}
	
	@Test
	public void calculateSumUsingDataService_empty(){
		// using mockito when() method and thenReturn() method 
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{});
		//business.setSomeDataService(dataServiceMock);
		int actualResult =  business.calculateSumUsingDataService(); 
		assertEquals(0, actualResult);
	}
	
	@Test
	public void calculateSumUsingDataService_OneValue(){
		// using mockito when() method and thenReturn() method 
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{5});
		//business.setSomeDataService(dataServiceMock);
		int actualResult =  business.calculateSumUsingDataService(); 
		assertEquals(5, actualResult);
	}
	
}
