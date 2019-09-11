package com.raghav.unitTest.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.raghav.unitTest.model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer>{

}
