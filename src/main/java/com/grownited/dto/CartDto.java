package com.grownited.dto;

public class CartDto {

	private Integer cartId;
	private Integer productId;
	private String quantity;
	private Integer userId;
	private String productName;
	private String offerPrice;
	
	
	public CartDto(Integer cartId, Integer productId, String quantity, Integer userId, String productName,
			String offerPrice) {
		super();
		this.cartId = cartId;
		this.productId = productId;
		this.quantity = quantity;
		this.userId = userId;
		this.productName = productName;
		this.offerPrice = offerPrice;
	}
	
	
	public Integer getCartId() {
		return cartId;
	}
	public void setCartId(Integer cartId) {
		this.cartId = cartId;
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
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
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
