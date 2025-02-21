package com.grownited.controller;

import java.util.List;
import java.util.Optional;

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
	
	@GetMapping("viewsubcategory")
	public String viewSubCategory(Integer subCategoryId, Model model) {
		
		Optional<SubCategoryEntity> op = repoSubCategory.findById(subCategoryId);
		
		if(op.isEmpty()) {
			//data not found
		} else {
			//data found
			SubCategoryEntity subCategory = op.get();
			
			//send data to jsp
			model.addAttribute("subCategory", subCategory);
		}
		
		return "ViewSubCategory";
	}
	
	@GetMapping("deletesubcategory")
	public String deleteSubCategroy(Integer subCategoryId, Model model) {
		
		repoSubCategory.deleteById(subCategoryId);
		
		return "redirect:/listsubcategory";
	}
}
