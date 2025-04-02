package com.grownited.controller.admin;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.grownited.entity.UserEntity;
import com.grownited.repository.OrdersRepository;
import com.grownited.repository.ProductRepository;
import com.grownited.repository.UserRepository;

@Controller
public class AdminController {
	
	@Autowired
	UserRepository repoUser;
	
	@Autowired
	ProductRepository repoProduct;
	
	@Autowired
	Cloudinary cloudinary;
	
	@Autowired
	OrdersRepository repoOrder;
	
	@GetMapping("admindashboard")
	public String adminDashboard(Model model) {
		
		//widgets-->
		//total user
		Long totalUsers = repoUser.count();//total of users table
		Integer totalUser = repoUser.findByRole("USER").size();// count excluding admin
		
		Integer totalAdmins = repoUser.findByRole("ADMIN").size();
		
		
		
		
		
		//this month user
		java.util.Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int month = cal.get(Calendar.MONTH) + 1;  // +1 because it starts with january = 0
		
		Integer thisMonthUsersCount = repoUser.countThisMonthUser(month);
		
		SimpleDateFormat sdf = new SimpleDateFormat("MMMM"); // "MMMM" gives full month name
		String monthName = sdf.format(date);
		
		
		//this month orders
		Integer thisMonthOrderCount = repoOrder.countThisMonthOrder(month);
		
		
		//total products
		Long totalProduct = repoProduct.count();
		
		
		// for user chart
		Integer monthWiseUsers [] = new Integer[12];
		
		for(int i=1;i<=12;i++) {
			monthWiseUsers [i-1] = repoUser.countThisMonthUser(i);
		}
		
		
		
		model.addAttribute("totalUser", totalUser);
		model.addAttribute("totalProduct", totalProduct);
		model.addAttribute("thisMonthUsersCount", thisMonthUsersCount);
		model.addAttribute("currentMonth", monthName);
		model.addAttribute("thisMonthOrderCount", thisMonthOrderCount);
		model.addAttribute("monthWiseUsers",monthWiseUsers);
		
		
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
	
	
	@GetMapping("edituser")
	public String editUser(Integer userId, Model model) {
		
		Optional<UserEntity> op = repoUser.findById(userId);
		
		if(op.isEmpty()) {
			return "redirect:/listuser";
		} else {
			model.addAttribute("user", op.get());
			return "EditUser";
		}
	}
	
	
	@PostMapping("updateuser")
  	public String updateUser(UserEntity userEntity,MultipartFile profilePic) {
  		
  		Optional<UserEntity> op = repoUser.findById(userEntity.getUserId());
  		
  		if(op.isPresent())
  		{
  			UserEntity dbUsers = op.get(); 
  			dbUsers.setFirstName(userEntity.getFirstName()); 
  			dbUsers.setLastName(userEntity.getLastName()); 
  			dbUsers.setEmail(userEntity.getEmail());
  			dbUsers.setContactNum(userEntity.getContactNum());
  			dbUsers.setGender(userEntity.getGender());
  			
  			if ((profilePic.getOriginalFilename().endsWith(".jpg") || profilePic.getOriginalFilename().endsWith(".webp") || profilePic.getOriginalFilename().endsWith(".png")
  					|| profilePic.getOriginalFilename().endsWith(".jpeg"))) {
  	 			try {
  	 				Map result = cloudinary.uploader().upload(profilePic.getBytes(), ObjectUtils.emptyMap());
  	 				dbUsers.setProfilePicPath(result.get("url").toString());
  	 			} catch (IOException e) {
  	 				// TODO Auto-generated catch block
  	 				e.printStackTrace();
  	 			}
  				
  			}
  		
  		
  			//
  			repoUser.save(dbUsers);
  		}
  		return "redirect:/listuser";
  	}
	
}
