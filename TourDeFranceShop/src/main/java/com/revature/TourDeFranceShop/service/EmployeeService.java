package com.revature.TourDeFranceShop.service;

import com.revature.TourDeFranceShop.models.User;

import java.util.List;

import com.revature.TourDeFranceShop.dao.EmployeeDB;

public class EmployeeService {
	private EmployeeDB employeeDB = new EmployeeDB(new ConnectionService());
	private User employee;
	
	public EmployeeService(User employee) {
		this.employee = employee;
	}
	
	//Methods that retrieve data from DB
	public void viewBikeRepairs() {
		List<String> repairs = employeeDB.getRepairList();
		System.out.format("%12s%12s%12s","Repair ID","Bike ID", "Status");
		System.out.println();
		for(int x=0; x < repairs.size(); x += 3) {
			int repairId = Integer.parseInt(repairs.get(x));
			int bikeId = Integer.parseInt(repairs.get(x+1));
			String status = repairs.get(x+2);
			System.out.format("%12d%12d%12s", repairId, bikeId, status);
			System.out.println();
		}
	}
	
	public void viewBillStatements() {
		List<String> statements = employeeDB.getBill();
		System.out.format("%12s%12s%12s%12s%12s","Bill ID","User ID", "Bike ID", "Balance","Status");
		System.out.println();
		for(int x=0; x < statements.size(); x += 5) {
			int billId = Integer.parseInt(statements.get(x));
			int userId = Integer.parseInt(statements.get(x+1));
			int bikeId = Integer.parseInt(statements.get(x+2));
			double balance = Double.parseDouble(statements.get(x+3));
			String status = statements.get(x+4);
			System.out.format("%12d%12d%12d%12.02f%12s",billId, userId,bikeId, balance,status);
			System.out.println();
		}
	}
	
	public void viewProducts() { //TODO: Close all db connections
		List<String> products = employeeDB.getProductList();
		System.out.format("%12s%12s%12s%12s%12s","Product ID","Name", "Price","Description","Status");
		System.out.println();
		for(int x=0; x < products.size(); x += 5) {
			int productId = Integer.parseInt(products.get(x));
			String name = products.get(x+1);
			double price = Double.parseDouble(products.get(x+2));
			String desc = products.get(x+3);
			String status = products.get(x+4);
			System.out.format("%12d%12s%12.02f%12s%12s", productId, name, price, desc, status);
			System.out.println();
		}
	}
	//Methods that insert data to DB
	public void setBillBalance(int customerId, int bikeId, double balance) {
		employeeDB.insertBalance(customerId, bikeId, balance);
	}
	
	public void addProduct(String name, double price, String desc) {
		employeeDB.insertProduct(name, price, desc);
	}
	//Methods that update data in DB
	public void changeRepairStatus(int repairId, String status) {
		employeeDB.updateRepairStatus(repairId, status);
		//TODO: validate repairId
	}
	
	public void changeBillStatus(int billId, String status) {
		employeeDB.updateBillStatus(billId, status);		
	}

	public void changeProductStatus(int productId, String status) {
		employeeDB.updateProductStatus(productId, status);	
	}

	public void changeProductPrice(int productId, double price) {
		employeeDB.updateProductPrice(productId, price);
	}
}
