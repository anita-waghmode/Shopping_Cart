package com.shoppingcart.model;

import javax.validation.constraints.NotBlank;


public class AddProductBO {
	
	
	@NotBlank(message = "Name is mandatory")
	private String productName;
	
	@NotBlank(message = "Product category is mandatory")
	private String productCategory;
	
	private int productId;
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	private Double productPrice;

	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	public Double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}
	
	
	
}
