package com.revature.TourDeFranceShop.service;

import java.util.Scanner;

import com.revature.TourDeFranceShop.dao.VerifyData;
import com.revature.TourDeFranceShop.models.User;

public class ValidationService {
	Scanner input = new Scanner(System.in);
	boolean invalid = true;
	private VerifyData verify = new VerifyData(new ConnectionService());
	//Check for valid input
	public int getValidOption(int optionNumber) {
		int validOption = 0;
		do {
			try {
				validOption = Integer.parseInt(input.nextLine());
				if(!(validOption > optionNumber)) {
					break;
				} else {
					System.out.println("Please select a valid option.");
				}
				
			} catch (NumberFormatException e) {
				System.out.println("Please select a valid option.");
			}
		} while(invalid);
		return validOption;
	}
	
	public int getValidCreditCard() {
		int creditCard = 0;
		do {
			System.out.println("Enter your 5 digit credit card number ex: 15924");	
			try {
				String inputCreditCard = input.nextLine();
				creditCard = Integer.parseInt(inputCreditCard);
				if(inputCreditCard.length() == 5) {
					break;
				} else {
					System.out.println("Please enter a valid credit card number.");
				}
				
			} catch (NumberFormatException e) {
				System.out.println("Please enter a valid credit card number.");
			}
		} while(invalid);
		return creditCard;
	}
	
	public String getValidString(String prompt) {
		String validInput = "";
		do {
			System.out.println(prompt);
			validInput = input.nextLine();
			if(!validInput.isEmpty()) {
				break;
			}
			System.out.println("Input cannot be empty.");
		} while (invalid);
		
		return validInput;
	}
	
	public int getValidInt() {
		int userInput = 0;
		do {
			try {
				userInput = Integer.parseInt(input.nextLine());
				break;
			} catch (NumberFormatException ex) {
				System.out.println("Please input a valid integer.");
			}
		} while(invalid);
		return userInput;
	}
	
	public double getValidDouble() {
		double userInput = 0;
		do {
			try {
				userInput = Double.parseDouble(input.nextLine());
				break;
			} catch (NumberFormatException ex) {
				System.out.println("Please input a valid integer.");
			}
		} while(invalid);
		return userInput;
	}
	
	//Check if input matches data in DB
	public String getValidUsername() {
		String username = "";
		do {
			System.out.println("Enter username: ");	
			username = input.nextLine();
			if(verify.checkUsername(username)) {
				break;
			}
		} while(invalid);
		return username;
	}
	
	public User getValidPassword(String uname) {
		User user = null;
		do {
			System.out.println("Enter password: ");	
			String passwd = input.nextLine();
			user = verify.checkPassword(uname, passwd);
			if(user != null) {
				break;
			}
		} while(invalid);
		return user;
	}
	
	public int getValidBillId() {
		int billId = 0;
		do {
			System.out.println("Enter bill ID: ");	
			billId = getValidInt();
			if(verify.checkBillId(billId)) {
				break;
			}
		} while(invalid);
		return billId;
	}
	
	public int getValidProductId() {
		int pId = 0;
		do {
			System.out.println("Enter product ID: ");	
			pId = getValidInt();
			if(verify.checkProductId(pId)) {
				break;
			}
		} while(invalid);
		return pId;
	}
	
	public int getValidRepairId() {
		int repairId = 0;
		do {
			System.out.println("Enter repair ID: ");	
			repairId = getValidInt();
			if(verify.checkRepairId(repairId)) {
				break;
			}
		} while(invalid);
		return repairId;
	}
	
	public int getValidCId() {
		int cId = 0;
		do {
			System.out.println("Enter bill ID: ");	
			cId = getValidInt();
			if(verify.checkCustomerId(cId)) {
				break;
			}
		} while(invalid);
		return cId;
	}
	
	public int getValidBikeId() {
		int bikeId = 0;
		do {
			System.out.println("Enter bike ID: ");	
			bikeId = getValidInt();
			if(verify.checkCustomerId(bikeId)) {
				break;
			}
		} while(invalid);
		return bikeId;
	}
}
