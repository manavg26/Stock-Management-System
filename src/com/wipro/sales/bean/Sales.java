package com.wipro.sales.bean;

public class Sales {
private String productID,salesId;
private double salesPricePerUnit;
private int quantitySold;
private java.util.Date salesDate;
public java.util.Date getSalesDate() {
	return salesDate;
}
public void setSalesDate(java.util.Date salesDate) {
	this.salesDate = salesDate;
}
public int getQuantitySold() {
	return quantitySold;
}
public void setQuantitySold(int quantitySold) {
	this.quantitySold = quantitySold;
}
public double getSalesPricePerUnit() {
	return salesPricePerUnit;
}
public void setSalesPricePerUnit(double salesPricePerUnit) {
	this.salesPricePerUnit = salesPricePerUnit;
}
public String getProductID() {
	return productID;
}
public void setProductID(String productID) {
	this.productID = productID;
}
public String getSalesId() {
	return salesId;
}
public void setSalesId(String salesId) {
	this.salesId = salesId;
}
}
