package com.grownited.controller;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.grownited.entity.UserEntity;
import com.grownited.repository.UserRepository;
import com.grownited.service.MailService;

import jakarta.servlet.http.HttpSession;

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
		return "Login";    // return jsp name
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
	
	@PostMapping("authenticate")
	public String authenticate(String email, String password, Model model, HttpSession session) {  // Model is passed to print message on page in case of invalid credentials
		
		//validate
//		System.out.println(email);
//		System.out.println(password);
		
		//user -> email, password
		Optional<UserEntity> op = repoUser.findByEmail(email);  // findByEmail has been created in UserRepository 
		//select * from users where email= :email and password= :password
		
		if(op.isPresent()) {
			//true
			//email
			
			UserEntity dbUser = op.get();  // if there will be valid email then users table will get copied in dbUser
			
			boolean ans = encoder.matches(password, dbUser.getPassword());
			
			if(ans == true) {
				
				//session -> user set
				session.setAttribute("user", dbUser);
				
				if(dbUser.getRole().equals("ADMIN")) {
					
					return "redirect:/admindashboard";   // will go to admin controller
					 
				} else if(dbUser.getRole().equals("USER")) {
					
					return "redirect:/home";
					
				} else {
					
					model.addAttribute("error", "Please contact Admin with Error Code #0991");
					
				}
				
			} 
			
		}
		
		model.addAttribute("error", "Invalid Credentials");
		return "Login";
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
	
	
	@GetMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		
		return "redirect:login";
	}
	
}
