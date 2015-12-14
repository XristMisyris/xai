package org.teipir.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.teipir.softeng.controllers.UserController;

public class TestUsers {
	
	private UserController user = null;

	@Before
	public void setUp() throws Exception {
		this.user = new UserController();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testDiaxiristis() {
		assertTrue(user.isValidTamias("tamias", "tamias"));
		assertFalse(user.isValidTamias("tamias123", "tamias123"));
	}
	
	@Test
	public void testTamia() {
		assertTrue(user.isValidDiaxiristis("admin", "admin"));
		assertFalse(user.isValidDiaxiristis("admin123", "admin123"));
	}

}
