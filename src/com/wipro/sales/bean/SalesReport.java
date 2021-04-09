package com.wipro.sales.bean;

public class SalesReport {

	private String salesId,productId,productName;
	private double productUnitPrice,salesPricePerUnit,profitAmount;
	private int quantitySold;
	private java.util.Date salesDate;

	public String getSalesId() {
		return salesId;
	}

	public void setSalesId(String salesId) {
		this.salesId = salesId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public double getSalesPricePerUnit() {
		return salesPricePerUnit;
	}

	public void setSalesPricePerUnit(double salesPricePerUnit) {
		this.salesPricePerUnit = salesPricePerUnit;
	}

	public double getProductUnitPrice() {
		return productUnitPrice;
	}

	public void setProductUnitPrice(double productUnitPrice) {
		this.productUnitPrice = productUnitPrice;
	}

	public double getProfitAmount() {
		return profitAmount;
	}

	public void setProfitAmount(double profitAmount) {
		this.profitAmount = profitAmount;
	}

	public int getQuantitySold() {
		return quantitySold;
	}

	public void setQuantitySold(int quantitySold) {
		this.quantitySold = quantitySold;
	}

	public java.util.Date getSalesDate() {
		return salesDate;
	}

	public void setSalesDate(java.util.Date salesDate) {
		this.salesDate = salesDate;
	}
}
