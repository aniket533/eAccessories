package com.grownited.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.grownited.entity.OrdersEntity;
import com.grownited.repository.OrdersRepository;

@Controller
public class OrdersController {
	
	@Autowired
	OrdersRepository repoOrders;
	
	@GetMapping("order")
	public String order() {
		return "Orders";
	}
	
	@PostMapping("saveorder")
	public String saveOrder(OrdersEntity ordersEntity) {
		
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
}
