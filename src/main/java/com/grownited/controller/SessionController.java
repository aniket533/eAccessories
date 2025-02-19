package com.grownited.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.grownited.entity.UserEntity;
import com.grownited.repository.UserRepository;
import com.grownited.service.MailService;

@Controller
public class SessionController {
	
	//mail service
	@Autowired
	MailService serviceMail;
	
	@Autowired
	UserRepository repoUser;   // object of UserRepository interface
	
	
	// creating object of PasswordEncoder to encrypt the password.
	@Autowired
	PasswordEncoder encoder;  // use this object in below method
	
	
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
//		System.out.println(userEntity.getFirstName());
//		System.out.println(userEntity.getLastName());
//		System.out.println(userEntity.getEmail());
//		System.out.println(userEntity.getPassword());
//		System.out.println(userEntity.getGender());
		
		
		String encPassword = encoder.encode(userEntity.getPassword());
		
		userEntity.setPassword(encPassword);
		
		
		
		userEntity.setRole("USER");  // default value of role
		userEntity.setCreatedAt(new Date());  // date value
		userEntity.setActive(true);
		repoUser.save(userEntity);  // insert query
		
		// send mail
		serviceMail.sendWelcomeMail(userEntity.getEmail(), userEntity.getFirstName());
		
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
