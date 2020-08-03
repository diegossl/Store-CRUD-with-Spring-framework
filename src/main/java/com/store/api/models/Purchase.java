package com.store.api.models;

import org.springframework.stereotype.Component;

@Component
public class Purchase {
	
	private String name;
	private String phone;
	private String productId;
	
	public Purchase() { }
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
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
