package com.grownited.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.grownited.entity.ProductEntity;
import com.grownited.entity.ReviewsEntity;
import com.grownited.entity.UserEntity;
import com.grownited.repository.ProductRepository;
import com.grownited.repository.ReviewsRepository;
import com.grownited.repository.UserRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class ReviewsController {
	
	@Autowired
	ReviewsRepository repoReviews;
	
	
	@Autowired
	ProductRepository repoProduct;
	
	@GetMapping("reviews")
	public String reviews() {
		
		List<ProductEntity> allProduct = repoProduct.findAll();
		
		return "Reviews";
	}
	
	@PostMapping("savereviews")
	public String saveReviews(ReviewsEntity reviewsEntity, HttpSession session) {
		
		// passing userId as foreign key
		UserEntity user = (UserEntity)session.getAttribute("user");
		Integer userId = user.getUserId();
		reviewsEntity.setUserId(userId);
		
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
	
	@GetMapping("viewreview")
	public String viewReview(Integer reviewId, Model model) {
		
		
		Optional<ReviewsEntity> op = repoReviews.findById(reviewId);
		
		if(op.isEmpty()) {
			//data not found
		} else {
			//data found
			ReviewsEntity review = op.get();
			
			//send data to jsp
			model.addAttribute("review", review);
		}
				
		return "ViewReview";
	}
	
	@GetMapping("deletereview")
	public String deleteReview(Integer reviewId, Model model) {
		
		repoReviews.deleteById(reviewId);
		
		return "redirect:/listreviews";
	}
}
