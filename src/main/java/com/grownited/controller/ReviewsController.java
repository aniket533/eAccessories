package com.grownited.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.grownited.entity.ReviewsEntity;
import com.grownited.repository.ReviewsRepository;

@Controller
public class ReviewsController {
	
	@Autowired
	ReviewsRepository repoReviews;
	
	@GetMapping("reviews")
	public String reviews() {
		return "Reviews";
	}
	
	@PostMapping("savereviews")
	public String saveReviews(ReviewsEntity reviewsEntity) {
		
		reviewsEntity.setCreatedAt(new Date());
		repoReviews.save(reviewsEntity);
		return  "redirect:/listreviews";
	}
	
	@GetMapping("listreviews")
	public String listReviews(Model model) {
		
		List<ReviewsEntity> reviewsList = repoReviews.findAll();
		
		model.addAttribute("reviewsList", reviewsList);
		
		return "ListReviews";
	}
}
