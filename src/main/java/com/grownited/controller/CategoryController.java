package com.grownited.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.grownited.entity.CategoryEntity;
import com.grownited.repository.CategoryRepository;

@Controller
public class CategoryController {
	
	@Autowired
	CategoryRepository repoCategory;
	
	@GetMapping("category")
	public String category() {
		return "NewCategory";
	}
	
	@PostMapping("savecategory")
	public String saveCategory(CategoryEntity categoryEntity) {
		repoCategory.save(categoryEntity);
		return "redirect:/listcategory";
	}
	
	@GetMapping("listcategory")
	public String listCategory(Model model) {
		
		List<CategoryEntity> categoryList = repoCategory.findAll();	
		
		model.addAttribute("categoryList", categoryList);
		
		return "ListCategory";
	}
}
