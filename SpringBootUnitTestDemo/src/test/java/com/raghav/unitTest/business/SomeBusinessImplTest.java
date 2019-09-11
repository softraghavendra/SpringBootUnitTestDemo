package com.raghav.unitTest.business;


import org.junit.Test;

// What is static import in java how to use it for own classes ? 
import static org.junit.Assert.assertEquals;


public class SomeBusinessImplTest {

	@Test
	public void calculateSum_Basic(){
		SomeBusinessImpl someBusinessImpl = new SomeBusinessImpl();
		int actualResult =  someBusinessImpl.calculateSum(new int[] {1, 2, 3});
		int expectedResult = 6;
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void calculateSum_empty(){
		SomeBusinessImpl someBusinessImpl = new SomeBusinessImpl();
		int actualResult =  someBusinessImpl.calculateSum(new int[] {});
		int expectedResult = 0;
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void calculateSum_OneValue(){
		SomeBusinessImpl someBusinessImpl = new SomeBusinessImpl();
		int actualResult =  someBusinessImpl.calculateSum(new int[] {5});
		int expectedResult = 5;
		assertEquals(expectedResult, actualResult);
	}
	
}
