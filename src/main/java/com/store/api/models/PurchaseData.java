package com.store.api.models;

import org.springframework.stereotype.Component;

@Component
public class PurchaseData extends Product {
	
	private Integer quantityPurchased;
	
	public PurchaseData() { }

	public Integer getQuantityPurchased() {
		return quantityPurchased;
	}

	public void setQuantityPurchased(Integer quantityPurchased) {
		this.quantityPurchased = quantityPurchased;
	}
}
