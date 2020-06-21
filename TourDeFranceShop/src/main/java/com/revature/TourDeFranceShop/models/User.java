package com.revature.TourDeFranceShop.models;

public class User {
	private String username;
	private String name; 
	private String role; 
	private int uId;
	
	public User() {	}
	public User(int uId, String username, String name, String role) {
		this.uId = uId;
		this.username = username;
		this.name = name;
		this.role = role;
	}
	
	public int getId() {
		return uId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	@Override
	public String toString() {
		return "User [username=" + username + ", name=" + name + ", role=" + role + "]";
	}
	
}
