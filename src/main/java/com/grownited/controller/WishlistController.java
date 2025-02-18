package com.grownited.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.grownited.entity.WishlistEntity;
import com.grownited.repository.WishlistRepository;

@Controller
public class WishlistController {
	@Autowired	
	WishlistRepository repoWishlist;
	
	@GetMapping("wishlist")
	public String wishlist() {
		return "Wishlist";
	}
	
	@PostMapping("savewishlist")
	public String saveWishlist(WishlistEntity wishlistEntity) {
		
		wishlistEntity.setCreatedAt(new Date());
		repoWishlist.save(wishlistEntity);
		return "redirect:/listwishlist";
	}
	
	@GetMapping("listwishlist")
	public String listWishlist(Model model) {
		
		List<WishlistEntity> wishlistList = repoWishlist.findAll();
		
		model.addAttribute("wishlistList", wishlistList);
		
		return "ListWishlist";
	}
}
