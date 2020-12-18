package com.productsandcategories.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.productsandcategories.models.Category;
import com.productsandcategories.models.Product;
import com.productsandcategories.services.CategoryService;
import com.productsandcategories.services.ProductService;

@Controller
public class CategoryController {
	@Autowired
	private ProductService prodServ;
	@Autowired
	private CategoryService catServ;

	@GetMapping("/categories/new")
	public String newCategory(@ModelAttribute("category") Category category) {
		return "/newCategory.jsp";
	}

	@PostMapping("/categories/new")
	public String createC(@Valid @ModelAttribute("category") Category category, BindingResult result) {
		if (result.hasErrors()) {
			return "/newCategory.jsp";
		} else {
			catServ.createCategory(category);
			return "redirect:/";
		}
	}

	@GetMapping("/categories/{id}")
	public String categoryDetails(Model model, @PathVariable("id") Long id) {
		Category category = catServ.findCategory(id);
		List<Product> allProducts = prodServ.getAllProducts();
		List<Product> catProds = category.getProducts();
		List<Product> someProducts = new ArrayList<>();

		for (Product prod : allProducts) {
			if (!catProds.contains(prod)) {
				someProducts.add(prod);
			} 
		}

		model.addAttribute("category", category);
		model.addAttribute("products", someProducts);

		return "/oneCategory.jsp";
	}

	@PostMapping("/categories")
	public String addCategory(@RequestParam("product_id") Long product_id,
			@RequestParam("category_id") Long category_id) {
		Product prod = prodServ.findProductById(product_id);
		Category cat = catServ.findCategoryById(category_id);
		cat.getProducts().add(prod);
		catServ.createCategory(cat);

		String id = String.valueOf(category_id);
		return "redirect:/categories/" + id;
	}

}
