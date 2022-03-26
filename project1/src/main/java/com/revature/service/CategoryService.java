package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.Category;
import com.revature.repository.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	CategoryRepository categoryRepository;
	
	public void createCategory(Category category) {
		categoryRepository.save(category);
	}

	public List<Category> listCategory() {
		return categoryRepository.findAll();
	}
}
