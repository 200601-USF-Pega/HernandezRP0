package com.revature.TourDeFranceShop.menus;

import java.util.Scanner;
import com.revature.TourDeFranceShop.models.User;

public class CustomerMenu implements IMenu{
	//Possibly change to CustomerService
	private User customer;
	
	public CustomerMenu() {}
	public CustomerMenu(User customer) {
		this.customer = customer;
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
		int option = Integer.parseInt(in.nextLine());
		switch(option) {
			case 1:
				System.out.println("View bike repair status");
				break;
			default:
				mainMenu();
		}
		
	}

	@Override
	public void bikeMenu() {
		// TODO Auto-generated method stub
		System.out.println("Your bike(s) repair status");
		//call method to retrieve bike info
	}

	@Override
	public void billMenu() {
		// TODO Auto-generated method stub
		
	}


}
