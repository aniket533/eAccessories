package com.grownited.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

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
	
	@GetMapping("viewwishlist")
	public String viewWishlist(Integer wishlistId, Model model) {
		
		Optional<WishlistEntity> op = repoWishlist.findById(wishlistId);
		
		if(op.isEmpty()) {
			//data not found
			
		} else {
			// data found
			WishlistEntity wishlist = op.get();
			
			//send data to jsp
			model.addAttribute("wishlist", wishlist);
		}
		
		
		return "ViewWishlist";
	}
	
	@GetMapping("deletewishlist")
	public String deleteWishlist(Integer wishlistId) {
		repoWishlist.deleteById(wishlistId);
		return "redirect:/listwishlist";
	}
}
