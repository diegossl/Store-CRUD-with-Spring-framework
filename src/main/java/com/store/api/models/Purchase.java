package com.store.api.models;

import org.springframework.stereotype.Component;

@Component
public class Purchase {
	
	private String name;
	private String email;
	private String phone;
	private String productId;
	
	public Purchase() { }
		
	public Purchase(String name, String email, String phone, String productId) {
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.productId = productId;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

}
