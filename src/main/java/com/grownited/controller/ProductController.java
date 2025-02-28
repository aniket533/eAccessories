package com.grownited.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.grownited.entity.CategoryEntity;
import com.grownited.entity.ProductEntity;
import com.grownited.entity.SubCategoryEntity;
import com.grownited.repository.CategoryRepository;
import com.grownited.repository.ProductRepository;
import com.grownited.repository.SubCategoryRepository;

@Controller
public class ProductController {
	
	@Autowired
	ProductRepository repoProduct;
	
	@Autowired
	CategoryRepository repoCategory;
	
	@Autowired
	SubCategoryRepository repoSubCategory;
	
	@GetMapping("newproduct")
	public String newProduct(Model model) {
		
		List<CategoryEntity> allCategory = repoCategory.findAll();
		model.addAttribute("allCategory", allCategory);
		
		List<SubCategoryEntity> allSubCategory = repoSubCategory.findAll();
		model.addAttribute("allSubCategory", allSubCategory);
		
		return "NewProduct";
	}
	
	@PostMapping("saveproduct")
	public String saveProduct(ProductEntity productEntity) {
		
		productEntity.setCreatedAt(new Date());
		
		repoProduct.save(productEntity);
		
		return "redirect:/listproduct";
	}
	
	@GetMapping("listproduct")
	public String listProduct(Model model) {
		List<ProductEntity> productList = repoProduct.findAll(); // select * from product, "productList" is a argument
		
		// how to send data from controller to jsp
		//Model
		model.addAttribute("productList", productList);
		
		return "ListProduct";
	}
	
	@GetMapping("viewproduct")
	public String viewProduct(Integer productId, Model model) {
		// ?
		Optional<ProductEntity> op = repoProduct.findById(productId);
		
		if(op.isEmpty()) {
			// not Found
		} else {
			// data found
			ProductEntity product = op.get();  //crerating object of entity, store product table into product variable
			
			// send data to jsp
			model.addAttribute("product", product);
		}
		
		return "ViewProduct";
	}
	
	
	@GetMapping("deleteproduct")
	public String deleteProduct(Integer productId) {
		
		repoProduct.deleteById(productId);  // delete from members where productId = :productId
		
		return "redirect:/listproduct";
	}
}
