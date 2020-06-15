package com.revature.TourDeFranceShop.menus;

import com.revature.TourDeFranceShop.models.User;

public class MenuFactory {
	public IMenu getMenu(User user) {
		switch(user.getRole()) {
			case"customer":
				return new CustomerMenu(user);
			case"employee":
				return new EmployeeMenu(user);
			default:
				return null;
		}
	}
}
