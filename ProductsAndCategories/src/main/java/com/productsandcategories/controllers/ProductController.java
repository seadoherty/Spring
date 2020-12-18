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
public class ProductController {
	@Autowired
	private ProductService prodServ;
	@Autowired
	private CategoryService catServ;

	@GetMapping("/")
	public String index() {
		return "redirect:/products/new";
	}

	@GetMapping("/products/new")
	public String newProduct(@ModelAttribute("product") Product product) {
		return "/newProduct.jsp";
	}

	@PostMapping("/products/new")
	public String createP(@Valid @ModelAttribute("product") Product product, BindingResult result) {
		if (result.hasErrors()) {
			return "/newProduct.jsp";
		} else {
			prodServ.createProduct(product);
			return "redirect:/";
		}
	}

	@GetMapping("/products/{id}")
	public String productDetails(Model model, @PathVariable("id") Long id) {
		Product product = prodServ.findProduct(id);
		List<Category> allCategories = catServ.allCategories();
		List<Category> prodCats = product.getCategories();
		List<Category> someCategories = new ArrayList<>();

		for (Category cat : allCategories) {
			if (!prodCats.contains(cat)) {
				someCategories.add(cat);
			}
		}
		model.addAttribute("product", product);
		model.addAttribute("categories", someCategories);

		return "/oneProduct.jsp";
	}

	@PostMapping("/products")
	public String addProduct(
			@RequestParam("category_id") Long category_id,
			@RequestParam("product_id") Long product_id
			) {
		Category cat = catServ.findCategoryById(category_id);
		Product prod = prodServ.findProductById(product_id);
		prod.getCategories().add(cat);
		prodServ.createProduct(prod);
		
		String id = String.valueOf(category_id);		
		return "redirect:/products/" + id;
	}
}
