package com.store.api.models;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

@Component
public class Purchase {
	
	private String buyerName;
	private String buyerPhone;
	private ArrayList<PurchaseData> productList;
	
	public Purchase() { }

	public String getBuyerName() {
		return buyerName;
	}

	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}

	public String getBuyerPhone() {
		return buyerPhone;
	}

	public void setBuyerPhone(String buyerPhone) {
		this.buyerPhone = buyerPhone;
	}


	public ArrayList<PurchaseData> getProductList() {
		return productList;
	}


	public void setProductList(ArrayList<PurchaseData> productList) {
		this.productList = productList;
	}

}
