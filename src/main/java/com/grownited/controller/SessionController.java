package com.grownited.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SessionController {
	@GetMapping(value = {"/", "signup"})
	public String signup() {
		return "Signup";
	}
	
	@GetMapping("login")  // url
	public String login() {  //method
		return "Login";    // return jsp name
	}
	
	@PostMapping("saveuser")
	public String saveUser() {
		return "Login";//jsp
	}
	
	@GetMapping("forgotpassword")
	public String forgotPassword() {
		return "ForgotPassword";//jsp
	}
}
