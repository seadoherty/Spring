package com.productsandcategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productsandcategories.models.Product;
import com.productsandcategories.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepo;

	public Product createProduct(Product p) {
		return productRepo.save(p);
	}

	public List<Product> getAllProducts() {
		return productRepo.findAll();
	}

	public Product findProduct(Long id) {
		Optional<Product> optionalProduct = productRepo.findById(id);
		if (optionalProduct.isPresent()) {
			return optionalProduct.get();
		} else {
			return null;
		}
	}

	public Product findProductById(Long product_id) {		
		return productRepo.findById(product_id).orElse(null);
	}
}
