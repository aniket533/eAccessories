package com.grownited.controller.admin;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.grownited.dto.CityDto;
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
	
	@GetMapping("listcity")
	public String listCity(Model model) {
		
		List<CityDto> cityList = repoCity.getAll();
		
		model.addAttribute("cityList", cityList);
		
		return "ListCity";
	}
	
	@GetMapping("viewcity")
	public String viewCity(Integer cityId, Model model) {
		
		Optional<CityEntity> op = repoCity.findById(cityId);
		
		if(op.isEmpty()) {
			// data not found
		} else {
			//data found
			CityEntity city = op.get();
			
			model.addAttribute("city", city);
		}
		
		return "ViewCity";
	}
	
	@GetMapping("deletecity")
	public String deleteCity(Integer cityId) {
		
		repoCity.deleteById(cityId);
		
		return "redirect:/listcity";
	}
}
