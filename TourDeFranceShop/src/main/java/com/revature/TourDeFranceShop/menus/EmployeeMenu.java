package com.revature.TourDeFranceShop.menus;

import java.util.Scanner;

import com.revature.TourDeFranceShop.models.User;
import com.revature.TourDeFranceShop.service.EmployeeService;
import com.revature.TourDeFranceShop.service.LoginService;
import com.revature.TourDeFranceShop.service.ValidationService;

public class EmployeeMenu implements IMenu {
	Scanner input = new Scanner(System.in);
	private EmployeeService employee;
	private ValidationService validate = new ValidationService();

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
		
		int option = validate.getValidOption(5);
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
			case 5:
				employee.logout();
		}
		
		
	}
	
	public void bikeRepairMenu() {
		employee.viewBikeRepairs();
		int repairId = validate.getValidRepairId();
		String prompt = "Change status to: ";
		String status = validate.getValidString(prompt);
		employee.changeRepairStatus(repairId, status);
		System.out.println("\n[0] Go back");
		if(validate.getValidOption(0) == 0) {
			mainMenu();
		}
	}
	
	public void setBalanceMenu() {
		System.out.println("Set bill balance for customer's bike repair");
		int customerId = validate.getValidCId();
		int bikeId = validate.getValidBikeId();
		System.out.println("Enter bill balance: ");
		double balance = Double.parseDouble(input.nextLine());
		employee.setBillBalance(customerId, bikeId, balance);
		System.out.println("\n[0] Go back");
		if(validate.getValidOption(0) == 0) {
			mainMenu();
		}
	}
	
	public void billStatusMenu() {
		System.out.println("Update bill status");
		employee.viewBillStatements();
		int billId = validate.getValidBillId();
		String prompt = "Enter status change: ";
		String status = validate.getValidString(prompt);
		employee.changeBillStatus(billId, status);
		System.out.println("\n[0] Go back");
		if(validate.getValidOption(0) == 0) {
			mainMenu();
		}
	}
	
	public void productsMenu() {
		employee.viewProducts();
		System.out.println("\n[0] Go back\n");
		System.out.println("Edit product\n"
						 + "[1] Change status\n"
						 + "[2] Edit price\n");
		System.out.println("Add product\n"
						 + "[3] Add new product");
		int option = validate.getValidOption(3);
		switch(option) {
			case 0:
				mainMenu();
				break;
			case 1:
				editProductMenu(option);
				break;
			case 2: 
				editProductMenu(option);
				break;
			case 3:
				addProductMenu();
				break;
		}
		
	}
	
	public void editProductMenu(int option) {
		int productId = validate.getValidProductId();
		if(option == 1) {
			String prompt = "Change product status to: ";
			String status = validate.getValidString(prompt);
			employee.changeProductStatus(productId, status);
		} else {
			System.out.println("Edit product price: ");
			double price = validate.getValidDouble();
			employee.changeProductPrice(productId, price);
		}
		System.out.println("\n[0] Go back");
		if(validate.getValidOption(0) == 0) {
			mainMenu();
		}
	}
	public void addProductMenu() {
		String prompt = "Enter product name: ";
		String name = validate.getValidString(prompt);
		System.out.println("Enter product price: ");
		double price = validate.getValidDouble();
		prompt = "Enter product description: ";
		String desc = validate.getValidString(prompt);
		employee.addProduct(name, price, desc);
		System.out.println("\n[0] Go back");
		if(validate.getValidOption(0) == 0) {
			mainMenu();
		}
	}

}
