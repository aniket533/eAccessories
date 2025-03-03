package com.grownited.dto;

import java.util.Date;

public class ReviewDto {
	private Integer reviewId;
	private Date createdAt;
	private Integer productId;
	private String rating;
	private String reviewText;
	private Integer userId;
	private String productName;
	
	
	
	public ReviewDto(Integer reviewId, Date createdAt, Integer productId, String rating, String reviewText,
			Integer userId, String productName) {
		super();
		this.reviewId = reviewId;
		this.createdAt = createdAt;
		this.productId = productId;
		this.rating = rating;
		this.reviewText = reviewText;
		this.userId = userId;
		this.productName = productName;
	}
	
	
	public Integer getReviewId() {
		return reviewId;
	}
	public void setReviewId(Integer reviewId) {
		this.reviewId = reviewId;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getReviewText() {
		return reviewText;
	}
	public void setReviewText(String reviewText) {
		this.reviewText = reviewText;
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
	
	
}
