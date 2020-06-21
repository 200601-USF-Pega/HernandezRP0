package com.revature.TourDeFranceShop.models;

import static org.junit.Assert.*;

import org.junit.*;

public class UserTest {
	
	User testUser;
	
	@Before
	public void dummyData() {
		testUser = new User(1, "paak","anderson", "employee");
	}
	
	@Test
	public void userRoleShouldBeEmployee() {
		assertEquals("employee", testUser.getRole());
	}
}
