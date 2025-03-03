package com.grownited.dto;

public class OrderDetailDto {
	private Integer orderDetailId;
	private Integer orderId;
	private String price;
	private Integer productId;
	private String quantity;
	private String status;
	private String productName;
	private String offerPrice;
	
	
	
	public OrderDetailDto(Integer orderDetailId, Integer orderId, String price, Integer productId, String quantity,
			String status, String productName, String offerPrice) {
		super();
		this.orderDetailId = orderDetailId;
		this.orderId = orderId;
		this.price = price;
		this.productId = productId;
		this.quantity = quantity;
		this.status = status;
		this.productName = productName;
		this.offerPrice = offerPrice;
	}
	
	public Integer getOrderDetailId() {
		return orderDetailId;
	}
	public void setOrderDetailId(Integer orderDetailId) {
		this.orderDetailId = orderDetailId;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getOfferPrice() {
		return offerPrice;
	}
	public void setOfferPrice(String offerPrice) {
		this.offerPrice = offerPrice;
	}
	
	
}
