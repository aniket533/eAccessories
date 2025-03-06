package com.grownited.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.grownited.dto.WishlistDto;
import com.grownited.entity.ProductEntity;
import com.grownited.entity.UserEntity;
import com.grownited.entity.WishlistEntity;
import com.grownited.repository.ProductRepository;
import com.grownited.repository.UserRepository;
import com.grownited.repository.WishlistRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class WishlistController {
	@Autowired	
	WishlistRepository repoWishlist;
	
	
	@Autowired
	ProductRepository repoProduct;
	
	@GetMapping("newwishlist")
	public String wishlist(Model model) {
		
		
		List<ProductEntity> allProduct = repoProduct.findAll();
		model.addAttribute("allProduct", allProduct);
		
		return "Wishlist";
	}
	
	@PostMapping("savewishlist")
	public String saveWishlist(WishlistEntity wishlistEntity, HttpSession session) {
		
		UserEntity user = (UserEntity)session.getAttribute("user");
		Integer userId = user.getUserId();
		wishlistEntity.setUserId(userId);
		
		wishlistEntity.setCreatedAt(new Date());
		repoWishlist.save(wishlistEntity);
		return "redirect:/listwishlist";
	}
	
	@GetMapping("listwishlist")
	public String listWishlist(Model model) {
		
		List<WishlistDto> wishlistList = repoWishlist.getAll();
		
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
