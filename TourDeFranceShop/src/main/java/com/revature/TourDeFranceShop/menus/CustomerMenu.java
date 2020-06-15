package com.revature.TourDeFranceShop.menus;

import java.util.Scanner;

import com.revature.TourDeFranceShop.dao.CustomerDB;
import com.revature.TourDeFranceShop.models.Bike;
import com.revature.TourDeFranceShop.models.User;
import com.revature.TourDeFranceShop.service.ConnectionService;
import com.revature.TourDeFranceShop.service.CustomerService;

public class CustomerMenu implements IMenu{
	private ConnectionService connect = new ConnectionService();
	private CustomerService customer;

	public CustomerMenu(User customer) {
		this.customer = new CustomerService(customer);
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
		
		Scanner in = new Scanner(System.in);
		int option = Integer.parseInt(in.nextLine()); //TODO: input verification (option)
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
			default:
				mainMenu();
		}
		in.close();
		
	}

	
	public void bikeRepairMenu() {
		System.out.println("Your bike(s) repair status\n");
		customer.getRepairStatus();
	}
	
	public void bikeRegisterMenu() {
		System.out.println("Please input your bike model (bike brand + model number) ex: trek73eg");
		Scanner in = new Scanner(System.in);
		Bike bikeModel = new Bike(in.nextLine()); //TODO: input verification (bike)
		customer.registerBike(bikeModel);
		in.close();
	}
	
	public void billMenu() {
		System.out.println("Your bill statements");
		customer.getBillStatements();
		System.out.println("\n[1] Pay bill\n[2] Return to main menu");
		Scanner in = new Scanner(System.in);
		int option = Integer.parseInt(in.nextLine()); //TODO: input verification (option)
		switch(option){
			case 1:
				//in.close();
				paymentMenu();
				break;
			case 2:
				//in.close();
				mainMenu();
				break;
		}
		
	}
	
	public void paymentMenu() {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the Bill ID: ");
		int billId = Integer.parseInt(in.nextLine()); //TODO: input verification (billId)
		System.out.println("Enter your 5 digit credit card number ex: 15924");	
		int creditCard = Integer.parseInt(in.nextLine()); //TODO: input verification (credit card)
		//TODO: add logic for pass or fail credit card verification
		customer.billPayment(billId); //TODO: add feedback
	}
	
	public void productsMenu() {
		customer.viewProducts();
		Scanner in = new Scanner(System.in);
		System.out.println("\nSelect the product ID you wish to purchase: ");
		int productId = Integer.parseInt(in.nextLine()); //TODO: input verification (billId)
		System.out.println("Enter your 5 digit credit card number ex: 15924");	
		int creditCard = Integer.parseInt(in.nextLine()); //TODO: input verification (credit card)
		//TODO: add logic for pass or fail credit card verification
		customer.buyProduct(productId); //TODO: add feedback
	}

}
