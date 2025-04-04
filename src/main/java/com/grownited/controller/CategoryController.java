package com.grownited.controller;

import java.util.List;
import java.util.Optional;

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
	
	@GetMapping("admincategory")
	public String category() {
		return "NewCategory";
	}
	
	@PostMapping("savecategory")
	public String saveCategory(CategoryEntity categoryEntity) {
		repoCategory.save(categoryEntity);
		return "redirect:/listcategory";
	}
	
	@GetMapping("adminlistcategory")
	public String listCategory(Model model) {
		
		List<CategoryEntity> categoryList = repoCategory.findAll();	
		
		model.addAttribute("categoryList", categoryList);
		
		return "ListCategory";
	}
	
	@GetMapping("viewcategory")
	public String viewCategory(Integer categoryId, Model model) {
		
		Optional<CategoryEntity> op = repoCategory.findById(categoryId);
		
		if(op.isEmpty()) {
			// not found
		} else {
			//data found
			CategoryEntity category = op.get();
			
			//send data to jsp
			model.addAttribute("category", category);
		}
		
		return "ViewCategory";
	}
	
	@GetMapping("deletecategory")
	public String deleteCategory(Integer categoryId) {
		
		repoCategory.deleteById(categoryId);
		
		return "redirect:/listcategory";
	}
	
}
