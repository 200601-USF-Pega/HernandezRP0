package com.revature.TourDeFranceShop.menus;

import com.revature.TourDeFranceShop.models.User;
import com.revature.TourDeFranceShop.service.LoginService;

//Class structure from Marielle Nolasco's github code
public class MenuFactory {
	public IMenu getMenu() {
		LoginService loginService = new LoginService();
		User user = loginService.login();
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
