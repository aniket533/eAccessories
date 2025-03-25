package com.grownited.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.grownited.dto.CartDto;
import com.grownited.entity.CartEntity;
import com.grownited.entity.ProductEntity;
import com.grownited.entity.UserEntity;
import com.grownited.repository.CartRepository;
import com.grownited.repository.ProductRepository;
import com.grownited.repository.UserRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class CartController {
	
	@Autowired
	CartRepository repoCart;
	
	@Autowired
	ProductRepository repoProduct;
	
	@Autowired
	UserRepository repoUser;
	
	@GetMapping("cart")
	public String cart(Model model) {
		
		
		List<ProductEntity> allProduct = repoProduct.findAll();
		model.addAttribute("allProduct", allProduct);
		
		return "NewCart";
	}
	
	@PostMapping("savecart")
	public String saveCart(CartEntity cartEntity, HttpSession session) {
		
		UserEntity user = (UserEntity)session.getAttribute("user");  // this always return as object, that's why we have to typecast into UserEntity.
		Integer UserId = user.getUserId();
		cartEntity.setUserId(UserId);
		
		
		repoCart.save(cartEntity);
		
		return "redirect:/listcart";
	}
	
	@GetMapping("listcart")
	public String listCart(Model model) {
		
		List<CartDto> cartList = repoCart.getAll();  // select * query
		
		model.addAttribute("cartList", cartList);
		
		return "ListCart";
	}
	
	@GetMapping("viewcart")
	public String viewCart(Integer cartId, Model model) {
		
		//?
		Optional<CartEntity> op = repoCart.findById(cartId);
		
		if(op.isEmpty()) {
			// not found
		} else {
			//data found
			CartEntity cart = op.get();
			
			// send data to jasp
			model.addAttribute("cart", cart);
		}
		
		return "ViewCart";
	}
	
	
	@GetMapping("deletecart")
	public String deleteCart(Integer cartId) {
		
		repoCart.deleteById(cartId); //delete from cart where cartID = :cartId
		
		return "redirect:/listcart";
	}
	
	
	@GetMapping("editcart")
	public String editCart(Integer cartId, Model model) {
		
		Optional<CartEntity> op = repoCart.findById(cartId);
		System.out.println(op.toString());
		if(op.isEmpty()) {
			return "redirect:/listcart";
		} else {
			model.addAttribute("cart", op.get());
			return "EditCart";
		}
		
	}
}
