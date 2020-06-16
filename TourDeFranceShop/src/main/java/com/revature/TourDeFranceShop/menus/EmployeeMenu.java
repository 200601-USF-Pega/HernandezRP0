package com.revature.TourDeFranceShop.menus;

import java.util.Scanner;

import com.revature.TourDeFranceShop.models.User;
import com.revature.TourDeFranceShop.service.EmployeeService;

public class EmployeeMenu implements IMenu {
	Scanner input = new Scanner(System.in);
	private EmployeeService employee;

	public EmployeeMenu(User user) {
		this.employee = new EmployeeService(user);
	}

	@Override
	public void mainMenu() {
		System.out.println("Welcome!");
		System.out.println("What would you like to do today?");
		System.out.println("[1] Update repair status\n"
						 + "[2] Set bill balance\n"
						 + "[3] Update bill balance status\n"
						 + "[4] Manage products\n"
						 + "[5] Logout");
		
		int option = Integer.parseInt(input.nextLine()); //TODO: Input verification (option)
		switch(option) {
			case 1:
				bikeRepairMenu();
				break;
			case 2:
				setBalanceMenu();
				break;
			case 3:
				billStatusMenu();
				break;
			case 4:
				productsMenu();
				break;
		}
		
		
	}
	
	public void bikeRepairMenu() {
		employee.viewBikeRepairs();
		System.out.println("Select Repair ID to update: ");
		int repairId = Integer.parseInt(input.nextLine());
		System.out.println("Change status to: "); //TODO: verification
		String status = input.nextLine();
		employee.changeRepairStatus(repairId, status);
	}
	
	public void setBalanceMenu() {
		System.out.println("Set bill balance for customer's bike repair");
		System.out.println("Enter customer id:");
		int customerId = Integer.parseInt(input.nextLine()); //TODO: verification
		System.out.println("Enter bike id: ");
		int bikeId = Integer.parseInt(input.nextLine());
		System.out.println("Enter bill balance: ");
		double balance = Double.parseDouble(input.nextLine());
		employee.setBillBalance(customerId, bikeId, balance);
	}
	
	public void billStatusMenu() {
		System.out.println("Update bill status");
		employee.viewBillStatements();
		System.out.println("Enter bill ID: ");
		int billId = Integer.parseInt(input.nextLine());
		System.out.println("Enter statuc change: ");
		String status = input.nextLine();
		employee.changeBillStatus(billId, status);
	}
	
	public void productsMenu() {
		employee.viewProducts();
		System.out.println("Edit product\n"
						 + "[1] Change status\n"
						 + "[2] Edit price\n"
						 + "[3] Both\n"); //TODO: Stretch goal
		System.out.println("Add product\n"
						 + "[4] Add new product");
		int option = Integer.parseInt(input.nextLine()); //TODO
		switch(option) {
			case 1:
				editProductMenu(option);
				break;
			case 2: 
				editProductMenu(option);
				break;
			case 4:
				addProductMenu();
				break;
		}
		
	}
	
	public void editProductMenu(int option) {
		System.out.println("Enter product ID: ");
		int productId = Integer.parseInt(input.nextLine());
		if(option == 1) {
			System.out.println("Change product status to: ");
			String status = input.nextLine();
			employee.changeProductStatus(productId, status);
		} else {
			System.out.println("Edit product price: ");
			double price = Double.parseDouble(input.nextLine());
			employee.changeProductPrice(productId, price);
		}
	}
	public void addProductMenu() {
		System.out.println("Enter product name: ");
		String name = input.nextLine();
		System.out.println("Enter product price: ");
		double price = Double.parseDouble(input.nextLine());
		System.out.println("Enter product description: ");
		String desc = input.nextLine();
		employee.addProduct(name, price, desc);
		
	}

}
