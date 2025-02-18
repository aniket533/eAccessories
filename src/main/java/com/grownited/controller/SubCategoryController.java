package com.grownited.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.grownited.entity.SubCategoryEntity;
import com.grownited.repository.SubCategoryRepository;

@Controller
public class SubCategoryController {
	
	@Autowired
	SubCategoryRepository repoSubCategory;
	
	@GetMapping("subcategory")
	public String subCategory() {
		return "SubCategory";
	}
	
	@PostMapping("savesubcategory")
	public String saveSubCategory(SubCategoryEntity subCategoryEntity) {
		
		repoSubCategory.save(subCategoryEntity);
		
		return "redirect:/listsubcategory";
	}
	
	
	@GetMapping("listsubcategory")
	public String listSubCategory(Model model) {
		
		List<SubCategoryEntity> subCategoryList = repoSubCategory.findAll();
		
		model.addAttribute("subCategoryList", subCategoryList);
		
		return "ListSubCategory";
	}
}
