package com.grownited.dto;

import java.util.Date;

public class WishlistDto {
	private Integer wishlistId;
	private Date createdAt;
	private Integer productId;
	private Integer userId;
	private String productName;
	private String offerPrice;
	
	public WishlistDto(Integer wishlistId, Date createdAt, Integer productId, Integer userId, String productName,
			String offerPrice) {
		super();
		this.wishlistId = wishlistId;
		this.createdAt = createdAt;
		this.productId = productId;
		this.userId = userId;
		this.productName = productName;
		this.offerPrice = offerPrice;
	}
	
	
	public Integer getWishlistId() {
		return wishlistId;
	}
	public void setWishlistId(Integer wishlistId) {
		this.wishlistId = wishlistId;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
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

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	
}
