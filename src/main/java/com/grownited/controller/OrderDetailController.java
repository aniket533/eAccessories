package com.grownited.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.grownited.entity.OrderDetailEntity;
import com.grownited.entity.OrdersEntity;
import com.grownited.entity.ProductEntity;
import com.grownited.repository.OrderDetailRepository;
import com.grownited.repository.OrdersRepository;
import com.grownited.repository.ProductRepository;

@Controller
public class OrderDetailController {

	@Autowired
	OrderDetailRepository repoOrderDetail;
	
	@Autowired
	ProductRepository repoProduct;
	
	@Autowired
	OrdersRepository repoOrder;
	
	@GetMapping("orderdetail")
	public String orderDetail() {
		
		List<ProductEntity> allProduct = repoProduct.findAll();
		
		List<OrdersEntity> allOrder = repoOrder.findAll();
		
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
	
	@GetMapping("vieworderdetail")
	public String viewOrderDetail(Integer orderDetailId, Model model) {
		
		Optional<OrderDetailEntity> op = repoOrderDetail.findById(orderDetailId);
		
		if(op.isEmpty()) {
			//not found
		} else {
			//data found
			OrderDetailEntity orderDetail = op.get();
			
			//send data to jsp
			model.addAttribute("orderDetail", orderDetail);
		}
				
		return "ViewOrderDetail";
	}
	
	@GetMapping("deleteorderdetail")
	public String deleteOrderDetail(Integer orderDetailId) {
		
		repoOrderDetail.deleteById(orderDetailId);
		
		return "redirect:/listorderdetail";
	}
}
