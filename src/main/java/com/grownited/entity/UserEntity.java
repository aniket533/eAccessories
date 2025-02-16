package com.grownited.entity;

import java.util.Date;

import jakarta.persistence.Column;
//import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity //create table
@Table(name = "users")  // table name set
public class UserEntity {
	@Id // primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;  //primary key, -> auto increment
	private String firstName;
	private String lastName;
	@Column(unique = true)
	private String email;
	private String password;
	private String contactNum;
	//private String bornYear;
	private String gender;
	private String role;  // buyer, seller, admin
	private Date createdAt;  // X -> today's date(default value)
	private Boolean active; // X -> true(default value)
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getContactNum() {
		return contactNum;
	}
	public void setContactNum(String contactNum) {
		this.contactNum = contactNum;
	}
//	public String getBornYear() {
//		return bornYear;
//	}
//	public void setBornYear(String bornYear) {
//		this.bornYear = bornYear;
//	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	
	
	
}
