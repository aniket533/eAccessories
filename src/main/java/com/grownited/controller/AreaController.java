package com.grownited.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.grownited.entity.AreaEntity;
import com.grownited.repository.AreaRepository;

@Controller
public class AreaController {
	
	@Autowired
	AreaRepository repoArea;
	
	@GetMapping("newarea")
	public String newArea() {
		return "NewArea";
	}
	
	@PostMapping("savearea")
	public String saveArea(AreaEntity areaEntity) {
		
		repoArea.save(areaEntity);
		
		return "NewArea";
	}
}
