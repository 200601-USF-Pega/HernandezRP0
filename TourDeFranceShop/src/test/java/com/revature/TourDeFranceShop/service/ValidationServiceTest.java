package com.revature.TourDeFranceShop.service;

import static org.junit.Assert.*;

import org.junit.*;

public class ValidationServiceTest {
	ValidationService validate = new ValidationService();
	
	@Test
	public void creditCardShouldBeInt() {
		System.out.println("Credit card:");
		validate.getValidCreditCard();
	}
	
	@Test
	public void optionShouldBeInt() {
		System.out.println("Option:");
		validate.getValidOption(3);
	}
	
	@Test 
	public void usernameShouldBeInDB() {
		System.out.println("Username");
		assertEquals("jApple", validate.getValidUsername());
	}
	
	@Test 
	public void passwordShouldBeInDB() {
		System.out.println("Password");
		validate.getValidPassword("jApple");
	}
}
