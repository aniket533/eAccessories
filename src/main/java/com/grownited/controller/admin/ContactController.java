package com.grownited.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.grownited.entity.ContactEntity;
import com.grownited.entity.UserEntity;
import com.grownited.repository.CartRepository;
import com.grownited.repository.ContactRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class ContactController {
	
	@Autowired
	ContactRepository repoContact;
	
	@Autowired
	CartRepository repoCart;
	
	
	
	@GetMapping("contact")
	public String contact(Model model, HttpSession session) {
		
		UserEntity user = (UserEntity) session.getAttribute("user");
		
		if (user != null) {
			int count = repoCart.getCartCountByUserId(user.getUserId());
			model.addAttribute("cartCount", count);
		} else {
			model.addAttribute("cartCount", 0);
		}
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
