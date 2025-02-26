package com.grownited.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import com.grownited.entity.CityEntity;
import com.grownited.entity.StateEntity;
import com.grownited.repository.CityRepository;
import com.grownited.repository.StateRepository;

@Controller
public class CityController {
	
	@Autowired
	StateRepository repoState;
	
	@Autowired
	CityRepository repoCity;
	
	@GetMapping("newcity")
	public String newCity(Model model) {
		//use state foreign key
		//select * from state;
		List<StateEntity> allState = repoState.findAll(); //all state
		
		//send data to JSP
		model.addAttribute("allState", allState);
		
		return "NewCity";
	}
	
	@PostMapping("savecity")
	public String saveCity(CityEntity cityEntity) {
		
		repoCity.save(cityEntity);
		return "redirect:/newcity";
	}
}
