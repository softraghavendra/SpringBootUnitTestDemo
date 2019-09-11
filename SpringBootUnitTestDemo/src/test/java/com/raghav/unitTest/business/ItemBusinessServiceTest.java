package com.raghav.unitTest.business;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.raghav.unitTest.business.ItemBusinessService;
import com.raghav.unitTest.data.ItemRepository;
import com.raghav.unitTest.model.Item;

// What is static import in java how to use it for own classes ? 
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class ItemBusinessServiceTest {
	
	@InjectMocks
	private ItemBusinessService itemBusinessService;
	
	@Mock
	private ItemRepository repository;

	@Test
	public void retrieveAllItems_Basic(){
		when(repository.findAll()).thenReturn(Arrays.asList(new Item(2, "Item2", 10, 10),
				new Item(3, "Item3", 20, 20)));
		List<Item> items = itemBusinessService.retrieveAllItems();
		assertEquals(100, items.get(0).getValue());
		assertEquals(400, items.get(1).getValue());
		
	}
	
}
