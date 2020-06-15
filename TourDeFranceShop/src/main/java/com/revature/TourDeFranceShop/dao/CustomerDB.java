package com.revature.TourDeFranceShop.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.revature.TourDeFranceShop.models.Bike;
import com.revature.TourDeFranceShop.service.ConnectionService;

public class CustomerDB {
	ConnectionService connection;
	
	public CustomerDB(ConnectionService connection) {
		this.connection = connection;
	}
	
	//Methods that retrieve data from DB
	
	public Map<Integer, String> viewRepairStatus(int uId) {
		Map<Integer,String> status= new HashMap<>();
		try {
			Statement s = connection.dbConnect().createStatement();
			s.executeQuery("SELECT bikeid, status FROM public.repair WHERE uid=" + uId+";");
			ResultSet results = s.getResultSet();
			while(results.next()) {
				int bikeModel = results.getInt("bikeid");
				String bikeStatus = results.getString("status");
				status.put(bikeModel, bikeStatus);
			}
			
		} catch (SQLException e) {
			System.out.println("Exception: " + e.getMessage());
			e.printStackTrace();
		}
		return status;
	}
	
	public List<String> viewBill(int uId) { 
		List<String> statements = new ArrayList<>();
		try {
			Statement s = connection.dbConnect().createStatement();
			s.executeQuery("SELECT billid, bikeid, balance, status  FROM public.bills WHERE uid=" + uId+";");
			ResultSet results = s.getResultSet();
			while(results.next()) {
				statements.add(results.getString("billid"));
				statements.add(results.getString("bikeid"));
				statements.add(results.getString("balance"));
				statements.add(results.getString("status"));
			}
			
		} catch (SQLException e) {
			System.out.println("Exception: " + e.getMessage());
			e.printStackTrace();
		}
		return statements;
	}
	
	public String getProductById(int productId) {
		String productName = "";
		try {
			Statement s = connection.dbConnect().createStatement();
			s.executeQuery("SELECT name FROM public.products WHERE pid=" + productId+";");
			ResultSet results = s.getResultSet();
			while(results.next()) {
				productName = results.getString("name");
			}
			
		} catch (SQLException e) {
			System.out.println("Exception: " + e.getMessage());
			e.printStackTrace();
		}
		return productName;
	}
	
	public List<String> getProductList(){
		List<String> products = new ArrayList<>();
		try {
			Statement s = connection.dbConnect().createStatement();
			s.executeQuery("SELECT * FROM public.products;");
			ResultSet results = s.getResultSet();
			while(results.next()) {
				products.add(results.getString("pid"));
				products.add(results.getString("name"));
				products.add(results.getString("price"));
				products.add(results.getString("description"));
				products.add(results.getString("status"));
			}
		} catch (SQLException e) {
			System.out.println("Exception: " + e.getMessage());
			e.printStackTrace();
		}
		return products;
	}
	//Methods that insert data to DB
	public String registerBike(Bike bike, int uId) {
		try {
			PreparedStatement s = connection.dbConnect().prepareStatement("INSERT INTO public.bikes (model, uid) VALUES (?, ?);");
			s.setString(1, bike.getModel());
			s.setInt(2, uId); 
			s.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Exception: " + e.getMessage());
			e.printStackTrace();
			return "Error: " + e.getMessage();
		}
		return "Successfully registered your bike (" + bike.getModel()+")!";
		
	}
	
	//Methods that change data in DB
	public void payBill(int billId) {
		String status = "pending";
		try {
			PreparedStatement s = connection.dbConnect().prepareStatement("UPDATE public.bills set status='" + status+"'"
					+ "WHERE billid="+billId+";");
			s.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Exception: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
}
