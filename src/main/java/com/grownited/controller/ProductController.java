package com.grownited.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.grownited.entity.ProductEntity;
import com.grownited.repository.ProductRepository;

@Controller
public class ProductController {
	
	@Autowired
	ProductRepository repoProduct;
	
	@GetMapping("newproduct")
	public String newProduct() {
		return "NewProduct";
	}
	
	@PostMapping("saveproduct")
	public String saveProduct(ProductEntity productEntity) {
		
		repoProduct.save(productEntity);
		
		return "NewProduct";
	}
}
