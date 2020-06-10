package com.revature.TourDeFranceShop.models;

public class Product {
	private String name;
	private double price;
	private String desc;
	private String status; 
	
	public Product() {}
	public Product(String name, double price, String desc, String status) {
		this.name = name;
		this.price = price;
		this.desc = desc;
		this.status = status; 
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "Product [name=" + name + ", price=" + price + ", desc=" + desc + ", status=" + status + "]";
	}
	
}
