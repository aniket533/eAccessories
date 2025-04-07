package com.grownited.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.grownited.entity.UserEntity;
import com.grownited.repository.UserRepository;

@Controller
public class AdminReportController {
	
	@Autowired
	UserRepository repoUser;
	
	@GetMapping("adminuserreport")
	public String adminUserReport(Model model) {
		
		List<UserEntity> activeUsers = repoUser.findByRoleAndActive("USER", true);
		
		model.addAttribute("activeUsers", activeUsers);
		
		return "AdminUserReport";
	}
}
