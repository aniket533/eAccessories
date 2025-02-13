package com.grownited.controller;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.grownited.entity.UserEntity;

@Controller
public class SessionController {
	@GetMapping(value = {"/", "signup"})
	public String signup() {
		return "Signup";
	}
	
	@GetMapping("login")  // url
	public String login() {  //method
		return "Home";    // return jsp name
	}
	
	@GetMapping("home")
	public String home() {
		return "Home";
	}
	
	@PostMapping("saveuser")
	public String saveUser(UserEntity userEntity) {
		
		//read
		System.out.println(userEntity.getFirstName());
		System.out.println(userEntity.getLastName());
		System.out.println(userEntity.getEmail());
		System.out.println(userEntity.getPassword());
		System.out.println(userEntity.getGender());
		
		return "Login";//jsp
	}
	
	@PostMapping("validateuser")
	public String validateUser(UserEntity userEntity) {
		
		//validate
		System.out.println(userEntity.getEmail());
		System.out.println(userEntity.getPassword());
		
		return "Home";
	}
	
	// open forgetpassword jsp
	@GetMapping("/forgotpassword")
	public String forgotPassword() {
		return "ForgotPassword";//jsp
	}
	
	//submit on forgetpassword ->
	@PostMapping("sendOtp")
	public String sendOtp() {
		return "ChangePassword";
	}
	
	@PostMapping("updatepassword")
	public String updatePassword() {
		return "Login";
	}
	
	
}
