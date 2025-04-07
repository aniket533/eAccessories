package com.grownited.controller.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.grownited.entity.SubCategoryEntity;
import com.grownited.repository.SubCategoryRepository;

@RestController
public class AjaxController {

	@Autowired
	SubCategoryRepository repoSubCategory; 
	
	
	@GetMapping("/getallsubcategorybycategoryid/{categoryId}")
	public List<SubCategoryEntity> getAllSubCateByCatId(@PathVariable Integer categoryId){
		
		List<SubCategoryEntity> allSubCategory = repoSubCategory.findByCategoryId(categoryId);
		
		return allSubCategory;
	}
	
	
}
