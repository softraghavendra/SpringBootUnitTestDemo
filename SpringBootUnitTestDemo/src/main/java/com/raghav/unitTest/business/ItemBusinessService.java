package com.raghav.unitTest.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.raghav.unitTest.data.ItemRepository;
import com.raghav.unitTest.model.Item;

@Component
public class ItemBusinessService {

	@Autowired
	private ItemRepository itemRepository;
	
	public Item retrieveHardCodedItem() {
		return new Item(1, "Ball", 10, 100);
	}
	
	public List<Item> retrieveAllItems(){
		List<Item> items = itemRepository.findAll();
		
		for(Item item:items){
			item.setValue(item.getPrice() * item.getQuantity());
		}
		return items;
	}

}
