package org.teipir.tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.teipir.softeng.controllers.DromologioController;
import org.teipir.softeng.models.Dromologio;

public class TestDromologia {
	
	private DromologioController dcont =  new DromologioController();

	@Test
	public void testGetDromologia() {
		List<Dromologio> dromologia = dcont.getAllDromologia();
		assertFalse(dromologia.isEmpty());
	}

	@Test
	public void testAddDromologio() {
		assertTrue(dcont.addDromologio("Καρπενήσι", "Πάτρα", "15:30", 25.00, 12.50));
	}
}
