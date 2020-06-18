package com.revature.TourDeFranceShop.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.TourDeFranceShop.models.User;
import com.revature.TourDeFranceShop.service.ConnectionService;

public class VerifyData {
	ConnectionService connection;
	private static final Logger logger = LogManager.getLogger(VerifyData.class);
	
	public VerifyData(ConnectionService connection) {
		this.connection = connection;
	}
	
	public Boolean checkUsername(String uname) {
		try {
			Statement s = connection.dbConnect().createStatement();
			s.executeQuery("SELECT username FROM public.users WHERE username='" + uname +"';");
			ResultSet results = s.getResultSet();
			while(results.next()) {
				return true;
			}
			
		} catch (SQLException e) {
			logger.error("Exception: " + e.getMessage());
		}
		return false;
	}

	public User checkPassword(String uname, String passwd) {
		User user = null;
		try {
			
			Statement s = connection.dbConnect().createStatement();
			s.executeQuery("SELECT uid, username, concat(fname, ' ',lname) as name, role  FROM public.users WHERE username='" + uname+"' "
					+ "AND passwd = '"+ passwd+ "';");
			ResultSet results = s.getResultSet();
			while(results.next()) {
				int uId = results.getInt("uid");
				String username = results.getString("username");
				String name = results.getString("name");
				String role = results.getString("role");
				user = new User(uId, username, name, role);
			}
		} catch (SQLException e) {
			logger.error("Exception: " + e.getMessage());
		}
		if(user != null)
			connection.finalize();
		return user;
	}
	
	public Boolean checkBillId(int billId) {
		try {
			Statement s = connection.dbConnect().createStatement();
			s.executeQuery("SELECT billid FROM public.bills WHERE billid='" + billId+"';");
			ResultSet results = s.getResultSet();
			while(results.next()) {
				return true;
			}
			
		} catch (SQLException e) {
			logger.error("Exception: " + e.getMessage());
		}
		return false;
	}
	
	public Boolean checkProductId(int pId) {
		try {
			Statement s = connection.dbConnect().createStatement();
			s.executeQuery("SELECT pid FROM public.products WHERE pid='" + pId+"';");
			ResultSet results = s.getResultSet();
			while(results.next()) {
				return true;
			}
			
		} catch (SQLException e) {
			logger.error("Exception: " + e.getMessage());
		}
		return false;
	}
	
	public Boolean checkRepairId(int repairId) {
		try {
			Statement s = connection.dbConnect().createStatement();
			s.executeQuery("SELECT repairid FROM public.repair WHERE repairid='" + repairId+"';");
			ResultSet results = s.getResultSet();
			while(results.next()) {
				return true;
			}
			
		} catch (SQLException e) {
			logger.error("Exception: " + e.getMessage());
		}
		return false;
	}
	
	public Boolean checkCustomerId(int cId) {
		try {
			Statement s = connection.dbConnect().createStatement();
			s.executeQuery("SELECT uid FROM public.users WHERE uid='" + cId+"';");
			ResultSet results = s.getResultSet();
			while(results.next()) {
				return true;
			}
			
		} catch (SQLException e) {
			logger.error("Exception: " + e.getMessage());
		}
		return false;
	}
	
	public Boolean checkBikeId(int bikeId) {
		try {
			Statement s = connection.dbConnect().createStatement();
			s.executeQuery("SELECT bikeid FROM public.bikes WHERE uid='" + bikeId+"';");
			ResultSet results = s.getResultSet();
			while(results.next()) {
				return true;
			}
			
		} catch (SQLException e) {
			logger.error("Exception: " + e.getMessage());
		}
		return false;
	}
}
