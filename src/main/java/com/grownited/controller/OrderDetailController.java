package com.grownited.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.grownited.entity.OrderDetailEntity;
import com.grownited.repository.OrderDetailRepository;

@Controller
public class OrderDetailController {

	@Autowired
	OrderDetailRepository repoOrderDetail;
	
	@GetMapping("orderdetail")
	public String orderDetail() {
		return "OrderDetail";
	}
	
	@PostMapping("saveorderdetail")
	public String saveOrderDetail(OrderDetailEntity orderDetailEntity) {
		
		repoOrderDetail.save(orderDetailEntity);
		return "redirect:/listorderdetail";
	}
	
	@GetMapping("listorderdetail")
	public String listOrderDetail(Model model) {
		
		List<OrderDetailEntity> orderDetailList = repoOrderDetail.findAll();
		
		model.addAttribute("orderDetailList", orderDetailList);
		
		return "ListOrderDetail";
	}
}
