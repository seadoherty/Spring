package com.productsandcategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productsandcategories.models.Category;
import com.productsandcategories.repositories.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepo;

	public Category createCategory(Category c) {
		return categoryRepo.save(c);
	}

	public List<Category> allCategories() {
		return categoryRepo.findAll();
	}

	public Category findCategory(Long id) {
		Optional<Category> optionalCategory = categoryRepo.findById(id);
		if (optionalCategory.isPresent()) {
			return optionalCategory.get();
		} else {
			return null;
		}
	}

	public Category findCategoryById(Long category_id) {
		return categoryRepo.findById(category_id).orElse(null);
	}

	
}