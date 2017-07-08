package com.softhover.categories.dao;

import java.util.List;

import com.softhover.categories.model.Category;

public interface CategoryDAO {
	
	boolean addCategory(Category category);
	List<Category> getAll();
}
