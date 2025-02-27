package com.grownited.controller.admin;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.grownited.entity.UserEntity;
import com.grownited.repository.UserRepository;

@Controller
public class AdminController {
	
	@Autowired
	UserRepository repoUser;
	
	@GetMapping("admindashboard")
	public String adminDashboard() {
		return "AdminDashboard";
	}
	
	@GetMapping("listuser")
	public String listUser(Model model) {
		
		List<UserEntity> users = repoUser.findAll();
		model.addAttribute("users", users);
		
		return "ListUser";
	}
	
	@GetMapping("viewuser")
	public String viewUser(Integer userId, Model model) {
		
		Optional<UserEntity> op = repoUser.findById(userId);
		
		if(op.isEmpty()) {
			// not found
		} else {
			UserEntity users = op.get();
			model.addAttribute("users", users);
		}
		
		return "ViewUser";
	}
	
	@GetMapping("deleteuser")
	public String deleteUser(Integer userId) {
		return "redirect:/listuser";
	}
}
