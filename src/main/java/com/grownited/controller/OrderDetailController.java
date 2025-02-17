package com.grownited.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
		return "OrderDetail";
	}
}
