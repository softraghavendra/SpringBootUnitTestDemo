package com.raghav.unitTest.business;


import org.junit.Test;

import com.raghav.unitTest.data.SomeDataService;

// What is static import in java how to use it for own classes ? 
import static org.junit.Assert.assertEquals;

class SomeDataServiceStub implements SomeDataService{

	@Override
	public int[] retrieveAllData() {
		return new int[] {1, 2, 3};
	}
	
}

class SomeDataServiceEmptyStub implements SomeDataService{

	@Override
	public int[] retrieveAllData() {
		return new int[] {};
	}
	
}


class SomeDataServiceOneValueStub implements SomeDataService{

	@Override
	public int[] retrieveAllData() {
		return new int[] {5};
	}
	
}


public class SomeBusinessStubTest {

	@Test
	public void calculateSumUsingDataService_Basic(){
		SomeBusinessImpl business = new SomeBusinessImpl();
		business.setSomeDataService(new SomeDataServiceStub());
		int actualResult =  business.calculateSumUsingDataService();
		int expectedResult = 6;
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void calculateSumUsingDataService_empty(){
		SomeBusinessImpl business = new SomeBusinessImpl();
		business.setSomeDataService(new SomeDataServiceEmptyStub());
		int actualResult =  business.calculateSumUsingDataService();
		int expectedResult = 0;
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void calculateSumUsingDataService_OneValue(){
		SomeBusinessImpl business = new SomeBusinessImpl();
		business.setSomeDataService(new SomeDataServiceOneValueStub());
		int actualResult =  business.calculateSumUsingDataService();
		int expectedResult = 5;
		assertEquals(expectedResult, actualResult);
	}
	
}
