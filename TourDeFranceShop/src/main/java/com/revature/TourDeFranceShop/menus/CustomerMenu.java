package com.revature.TourDeFranceShop.menus;

import java.util.Scanner;

public class CustomerMenu implements IMenu{

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
		//int option = in.nextLine();
		switch(option) {
			case 1:
				System.out.println("View bike repair status");
				break;
			default:
				mainMenu();
		}
		
	}


}
