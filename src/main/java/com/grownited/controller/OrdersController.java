package com.grownited.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.grownited.entity.OrdersEntity;
import com.grownited.entity.UserEntity;
import com.grownited.repository.OrdersRepository;
import com.grownited.repository.UserRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class OrdersController {
	
	@Autowired
	OrdersRepository repoOrders;
	
	
	
	@GetMapping("neworder")
	public String order(Model model) {
				
		return "Orders";
	}
	
	@PostMapping("saveorder")
	public String saveOrder(OrdersEntity ordersEntity, HttpSession session) {
		
		UserEntity user = (UserEntity)session.getAttribute("user");
		Integer userId = user.getUserId();
		ordersEntity.setUserId(userId);
		
		ordersEntity.setCreatedAt(new Date());
		repoOrders.save(ordersEntity);
		return "redirect:/listorder";
	}
	
	@GetMapping("listorder")
	public String listOrder(Model model) {
		
		List<OrdersEntity> orderList = repoOrders.findAll();
		
		model.addAttribute("orderList", orderList);
		
		return "ListOrders";
	}
	
	@GetMapping("vieworder")
	public String viewOrder(Integer orderId, Model model) {
		
		
	//	Optional<OrdersEntity> op = repoOrders.findById(orderId);
		
	//	if(op.isEmpty()) {
			//data not found
	//	} else {
			//data found
		//	OrdersEntity order = op.get();
			
			//send data to jsp
		//	model.addAttribute("order", order);
	//	}
		
		List<Object[]> op = repoOrders.getByOrderId(orderId);
		model.addAttribute("order", op);
		
		return "ViewOrders";
	}
	
	@GetMapping("deleteorder")
	public String deleteOrder(Integer orderId) {
		
		repoOrders.deleteById(orderId);
		return "redirect:/listorder";
	}
}
