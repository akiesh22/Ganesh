package com.softhover.categories.dao;

import java.util.List;

import com.softhover.categories.model.Category;
import com.softhover.categories.model.Item;

public interface ItemDAO {

	boolean addItem(Item item, int i);
	public List<Item> getAll();
	public List<Item> getAll(int i);
	
}
