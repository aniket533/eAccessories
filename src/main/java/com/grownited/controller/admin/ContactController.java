package com.grownited.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.grownited.entity.ContactEntity;
import com.grownited.repository.ContactRepository;

@Controller
public class ContactController {
	
	@Autowired
	ContactRepository repoContact;
	
	
	
	@GetMapping("contact")
	public String contact() {
		return "Contact";
	}
	
	@PostMapping("savecontact")
	public String saveContact(ContactEntity contactEntity) {
		
		repoContact.save(contactEntity);
		
		return "Contact";
	}
	
	@GetMapping("listcontact")
	public String listContact(Model model) {
		
		List<ContactEntity> contactList = repoContact.findAll();
		
		model.addAttribute("contactList", contactList);
		
		return "ListContact";
	}
}
