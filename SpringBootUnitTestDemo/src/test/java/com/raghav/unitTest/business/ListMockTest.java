package com.raghav.unitTest.business;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.ArgumentCaptor;

import static org.mockito.Mockito.*;
import static org.junit.Assert.assertEquals;


public class ListMockTest {
	
	List<String> mockList = mock(List.class);
	
	@Test
	public void size_basic(){
		when(mockList.size()).thenReturn(5);
		assertEquals(5, mockList.size());
	}	
	
	@Test
	public void retrnDifferentValues(){
		when(mockList.size()).thenReturn(5).thenReturn(10);
		assertEquals(5, mockList.size());
		assertEquals(10, mockList.size());
	}

	@Test
	public void retrnWithParameter(){
		when(mockList.get(0)).thenReturn("raghav");
		assertEquals("raghav", mockList.get(0));
		assertEquals(null, mockList.get(1));
	}
	
	//Example of argument matcher like anyInt()
	@Test
	public void retrnWithGenericParameter(){
		when(mockList.get(anyInt())).thenReturn("raghav");
		assertEquals("raghav", mockList.get(99));
		assertEquals("raghav" , mockList.get(1));
	}
	
	@Test
	public void varificationBasics(){
		// SUT (Means System Under Test)
		// here we are mocking our object using get() method after that we verify it.
		String value1 = mockList.get(0);
		String value2 = mockList.get(1);
		
		//verify
		verify(mockList).get(0);
		
		// verify using argument matcher
		verify(mockList).get(1);
		
		// verify number of times any method called or not ?
		verify(mockList, times(2)).get(anyInt());
		
		verify(mockList, atLeastOnce()).get(anyInt());
		verify(mockList, atMost(2)).get(anyInt());
		verify(mockList, never()).get(2);
		
	}
	
	
	@Test
	public void argumentCapturing(){
		//SUT
		mockList.add("someString");
		
		//verification
		ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);
		verify(mockList).add(argumentCaptor.capture());
		
		assertEquals("someString", argumentCaptor.getValue());
	}
	
	
	@Test
	public void multipleArgumentCapturing(){
		//SUT
		mockList.add("someString1");
		mockList.add("someString2");
		
		//verification
		ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);
		verify(mockList, times(2)).add(argumentCaptor.capture());
		
		//verify(mockList).add(argumentCaptor.capture()); is wrong as we are adding two times
		
		List<String> allValues = argumentCaptor.getAllValues();
		
		assertEquals("someString1", allValues.get(0));
	}
	
	/*
	 * Mocking object does not retain behavior of original class
	 * its only do what we say.
	 * 
	 */
	
	@Test
	public void mocking(){
		ArrayList<String> arrayListMock = mock(ArrayList.class);
		System.out.println(arrayListMock.get(0));// null
		System.out.println(arrayListMock.size());// 0
		arrayListMock.add("Test1");
		arrayListMock.add("Test2");
		System.out.println(arrayListMock.get(0));// 0
		when(arrayListMock.size()).thenReturn(5);
		System.out.println(arrayListMock.size());// 5
	}
	
	/*
	 * Spy object work like real world object in java.
	 * 
	 * 
	 */
	@Test
	public void spying(){
		ArrayList<String> arrayListMock = spy(ArrayList.class);
		//System.out.println(arrayListMock.get(0));// exception as we were not adding anything to arrayListMock
		System.out.println(arrayListMock.size());// 0
		arrayListMock.add("Test1");
		arrayListMock.add("Test2");
		System.out.println(arrayListMock.get(0));// 0
		when(arrayListMock.size()).thenReturn(5);
		System.out.println(arrayListMock.size());// 5
		
		arrayListMock.add("Test4");
		verify(arrayListMock).add("Test4");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
