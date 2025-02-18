package com.grownited.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	
	@GetMapping("listproduct")
	public String listProduct(Model model) {
		List<ProductEntity> productList = repoProduct.findAll(); // select * from product, "productList" is a argument
		
		// how to send data from controller to jsp
		//Model
		model.addAttribute("productList", productList);
		
		return "ListProduct";
	}
}
