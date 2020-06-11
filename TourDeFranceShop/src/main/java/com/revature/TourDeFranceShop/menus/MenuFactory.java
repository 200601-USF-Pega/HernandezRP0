package com.revature.TourDeFranceShop.menus;

public class MenuFactory {
	public IMenu getMenu(String userRole) {
		switch(userRole) {
			case"customer":
				return new CustomerMenu();
			case"employee":
				return new EmployeeMenu();
			default:
				return null;
		}
	}
}
