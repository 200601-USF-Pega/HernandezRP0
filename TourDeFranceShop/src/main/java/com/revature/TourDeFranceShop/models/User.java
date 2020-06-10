package com.revature.TourDeFranceShop.models;

public class User {
	private String username;
	private String name; 
	private String role; 
	
	public User() {}
	public User(String username, String name, String role) {
		this.username = username;
		this.name = name;
		this.role = role;
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