package org.teipir.tests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.teipir.softeng.controllers.DromologioController;
import org.teipir.softeng.models.Dromologio;

public class TestDromologia {
	
	private DromologioController dcont = new DromologioController();

	@Before
	public void setUp() throws Exception {
		this.dcont = new DromologioController();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetDromologia() {
		DromologioController dcont = new DromologioController();
		
		List<Dromologio> dromologia = dcont.getAllDromologia();
		assertFalse(dromologia.isEmpty());
	}

	@Test
	public void testAddDromologio() {
		assertTrue(dcont.addDromologio("Καρπενήσι", "Πάτρα", "15:30", 25.00, 12.50));
	}
}
