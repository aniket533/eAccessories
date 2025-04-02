package com.grownited.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.grownited.entity.UserEntity;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {

	@GetMapping("home")
	public String home() {
		
		
		return "Home";
	}
	
	@GetMapping("userhome")
	public String userHome(HttpSession session, Model model) {
		UserEntity user = (UserEntity)session.getAttribute("user");
		Integer userId = user.getUserId();
		
		model.addAttribute("userId", userId);
		return "UserHome";
	}
}
