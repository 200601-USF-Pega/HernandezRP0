package com.revature.TourDeFranceShop.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.TourDeFranceShop.models.User;

public class LoginService {
	private static final Logger logger = LogManager.getLogger(LoginService.class);
	private ValidationService validate = new ValidationService();
	public User login() {
		String uname = validate.getValidUsername();
		User user =validate.getValidPassword(uname);
		logger.info("User logged in");
		return user;
	}
}
