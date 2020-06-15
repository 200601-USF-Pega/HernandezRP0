package com.revature.TourDeFranceShop.service;

import java.util.List;
import java.util.Map;

import com.revature.TourDeFranceShop.dao.CustomerDB;
import com.revature.TourDeFranceShop.models.Bike;
import com.revature.TourDeFranceShop.models.User;

public class CustomerService {
	private CustomerDB custDB = new CustomerDB(new ConnectionService());
	private User customer;
	
	public CustomerService(User customer) {
		this.customer = customer;
	}

	//Methods that retrieve data from DB
	public void getRepairStatus() {
		Map<Integer, String> status = custDB.viewRepairStatus(customer.getId());
		System.out.println("Bike ID \t Repair Status");
		for(Map.Entry x: status.entrySet()) {
			System.out.print(x.getKey());
			System.out.print("\t\t ");
			System.out.println(x.getValue());
		}
	}
	
	public void getBillStatements() {
		List<String> statements = custDB.viewBill(customer.getId());
		System.out.format("%12s%12s%12s%12s","Bill ID","Bike ID", "Balance","Status");
		System.out.println();
		for(int x=0; x < statements.size(); x += 4) {
			int billId = Integer.parseInt(statements.get(x));
			int bikeId = Integer.parseInt(statements.get(x+1));
			double balance = Double.parseDouble(statements.get(x+2));
			String status = statements.get(x+3);
			System.out.format("%12d%12d%12.02f%12s",billId,bikeId, balance,status);
			System.out.println();
		}
	}
	
	public void viewProducts() { //TODO: Close all db connections
		List<String> products = custDB.getProductList();
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
	
	public void buyProduct(int productId) {
		String purchasedProduct = custDB.getProductById(productId);
		System.out.println("You have pruchased: " + purchasedProduct);
	}
	//Methods that insert data to DB
	public void registerBike(Bike bike) {
		String success = custDB.registerBike(bike, customer.getId());
		System.out.println(success);
	}
	
	public void billPayment(int billId) {
		custDB.payBill(billId);
	}
	
}
