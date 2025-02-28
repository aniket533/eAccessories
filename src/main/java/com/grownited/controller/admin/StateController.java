package com.grownited.controller.admin;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.grownited.entity.StateEntity;
import com.grownited.repository.StateRepository;

@Controller
public class StateController {
	
	// user will give input
	// we'll process
	@Autowired
	StateRepository repoState;  // object of StateRepository interface
	
	@GetMapping("newstate")
	public String newState() {
		return "NewState";
	}
	
	@PostMapping("savestate")
	public String saveState(StateEntity state) {
		System.out.println(state.getStateName());
		
		repoState.save(state);//insert query for hibernate
		
		return "NewState";
	}
	
	@GetMapping("liststate")
	public String listState(Model model) {
		
		List<StateEntity> stateList = repoState.findAll();
		
		model.addAttribute("stateList", stateList);
		
		return "ListState";
	}
	
	@GetMapping("viewstate")
	public String viewState(Integer stateId, Model model) {
		
		Optional<StateEntity> op = repoState.findById(stateId);
		
		if(op.isEmpty()) {
			// not found
		} else {
			StateEntity state = op.get();
			
			model.addAttribute("state", state);
		}
		
		return "ViewState";
	}
	
	@GetMapping("deletestate")
	public String deleteState(Integer stateId) {
		
		repoState.deleteById(stateId);
		
		return "redirect:/liststate";
	}
}
