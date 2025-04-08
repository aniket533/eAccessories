package com.grownited.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.grownited.entity.ProductEntity;
import com.grownited.entity.UserEntity;
import com.grownited.repository.CartRepository;
import com.grownited.repository.ProductRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {

	@Autowired
	ProductRepository repoProduct;
	
	@Autowired
	CartRepository repoCart;
	
	@GetMapping("home")
	public String home() {
		
		
		return "Home";
	}
	
	@SuppressWarnings("unused")
	@GetMapping("userhome")
	public String userHome(HttpSession session, Model model) {
		UserEntity user = (UserEntity)session.getAttribute("user");
		Integer userId = user.getUserId();
		
		List<ProductEntity> allProduct = repoProduct.findAll();
		model.addAttribute("allProduct",allProduct); 
		
		
		model.addAttribute("userId", userId);
		
		if (user != null) {
			int count = repoCart.getCartCountByUserId(user.getUserId());
			model.addAttribute("cartCount", count);
		} else {
			model.addAttribute("cartCount", 0);
		}
		
		return "UserHome";
	}
}
