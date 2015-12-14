package org.teipir.tests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.teipir.softeng.controllers.EisitirioController;

public class TestEisitiria {

	private EisitirioController eisCont =  new EisitirioController();

	@Test
	public void testAddEisitirio() {
		assertTrue(eisCont.addEisitirio("Καρπενήσι", "Πάτρα", "2015-12-14", 30, 1, 12.5));
	}

}
