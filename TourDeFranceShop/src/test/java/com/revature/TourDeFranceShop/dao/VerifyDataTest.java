package com.revature.TourDeFranceShop.dao;

import static org.junit.Assert.*;

import org.junit.*;

import com.revature.TourDeFranceShop.service.ConnectionService;

public class VerifyDataTest {
	VerifyData verify = new VerifyData(new ConnectionService());

	@Test
	public void billIdShouldBeInDB() {
		assertEquals(true, verify.checkBillId(1));
	}
	
	@Test
	public void repairIdShouldNotBeInDB() {
		assertEquals(false, verify.checkRepairId(213));
	}
}
