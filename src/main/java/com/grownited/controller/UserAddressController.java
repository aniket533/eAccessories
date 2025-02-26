package com.grownited.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.grownited.entity.CityEntity;
import com.grownited.entity.StateEntity;
import com.grownited.entity.UserAddressEntity;
import com.grownited.entity.UserEntity;
import com.grownited.repository.CityRepository;
import com.grownited.repository.StateRepository;
import com.grownited.repository.UserAddressRepository;
import com.grownited.repository.UserRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserAddressController {
	
	@Autowired
	UserAddressRepository repoUserAddress;
		
	@Autowired
	StateRepository repoState;
	
	@Autowired
	CityRepository repoCity;
	
	@GetMapping("newuseraddress")
	public String newUserAddress(Model model, HttpSession session) {
		
		
		
		List<StateEntity> allState = repoState.findAll();
		
		model.addAttribute("allState", allState);
		
		List<CityEntity> allCity = repoCity.findAll();
		
		model.addAttribute("allCity", allCity);
		
		return "NewUserAddress";
	}
	
	@PostMapping("saveuseraddress")
	public String saveUserAddress(UserAddressEntity userAddressEntity) {
		
		repoUserAddress.save(userAddressEntity);
		
		return "redirect:/newuseraddress";
	}
}
