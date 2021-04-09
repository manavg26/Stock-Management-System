package com.wipro.sales.bean;
//TBL_STOCK
public class Product {
	private String productID,productName;
	private int QuantiyOnHand,recorderLevel;
	private double productUnitPrice;
	public double getProductUnitPrice() {
		return productUnitPrice;
	}
	public void setProductUnitPrice(double productUnitPrice) {
		this.productUnitPrice = productUnitPrice;
	}
	public int getQuantiyOnHand() {
		return QuantiyOnHand;
	}
	public void setQuantiyOnHand(int quantiyOnHand) {
		this.QuantiyOnHand = quantiyOnHand;
	}
	public int getRecorderLevel() {
		return recorderLevel;
	}
	public void setRecorderLevel(int recorderLevel) {
		this.recorderLevel = recorderLevel;
	}
	public String getProductID() {
		return productID;
	}
	public void setProductID(String productID) {
		this.productID = productID;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	

	
}
