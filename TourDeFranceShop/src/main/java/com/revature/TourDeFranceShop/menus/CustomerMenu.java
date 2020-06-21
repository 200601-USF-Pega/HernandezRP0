package com.revature.TourDeFranceShop.menus;

import java.util.Scanner;

import com.revature.TourDeFranceShop.models.Bike;
import com.revature.TourDeFranceShop.models.User;
import com.revature.TourDeFranceShop.service.CustomerService;
import com.revature.TourDeFranceShop.service.LoginService;
import com.revature.TourDeFranceShop.service.ValidationService;

public class CustomerMenu implements IMenu{
	Scanner input = new Scanner(System.in);
	private CustomerService customer;
	private ValidationService validate = new ValidationService();

	public CustomerMenu(User user) {
		this.customer = new CustomerService(user);
	}
	
	@Override
	public void mainMenu() {
		System.out.println("Welcome to Tour De France Bike Shop!");
		System.out.println("What would you like to do today?");
		System.out.println("[1] View bike repair status\n"
						 + "[2] Register bike\n"
						 + "[3] View/Pay my bill\n"
						 + "[4] Purchase bike products and accessories\n"
						 + "[5] Logout");
		
		int option = validate.getValidOption(5);
		switch(option) {
			case 1:
				bikeRepairMenu();
				break;
			case 2:
				bikeRegisterMenu();
				break;
			case 3:
				billMenu();
				break;
			case 4:
				productsMenu();
				break;
			case 5:
				customer.logout();
		}
		
	}

	
	public void bikeRepairMenu() {
		System.out.println("Your bike(s) repair status\n");
		customer.getRepairStatus();
		System.out.println("\n[0] Go back");
		if(Integer.parseInt(input.nextLine()) == 0) {
			mainMenu();
		}
	}
	
	public void bikeRegisterMenu() {
		String prompt = "Please input your bike model (bike brand + model number) ex: trek73eg";
		Bike bikeModel = new Bike(validate.getValidString(prompt));
		customer.registerBike(bikeModel);
		System.out.println("\n[0] Go back");
		if(validate.getValidOption(0) == 0) {
			mainMenu();
		}
	}
	
	public void billMenu() {
		System.out.println("Your bill statements");
		customer.getBillStatements();
		System.out.println("\n[0] Return to main menu\n[1] Pay bill");
		int option = validate.getValidOption(1);
		switch(option){
			case 0:
				mainMenu();
				break;
			case 1:
				paymentMenu();
				break;
		}
		
	}
	
	public void paymentMenu() {
		int billId = validate.getValidBillId();	
		int creditCard = validate.getValidCreditCard();
		customer.billPayment(billId); 
		System.out.println("Paid!");
		System.out.println("\n[0] Go back");
		if(validate.getValidOption(0) == 0) {
			mainMenu();
		}
	}
	
	public void productsMenu() {
		customer.viewProducts();
		System.out.println("\nSelect the product you wish to purchase");
		int productId = validate.getValidProductId();
		int creditCard = validate.getValidCreditCard();
		customer.buyProduct(productId); 
		System.out.println("\n[0] Go back");
		if(validate.getValidOption(0) == 0) {
			mainMenu();
		}
	}

}
