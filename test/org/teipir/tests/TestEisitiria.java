package org.teipir.tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.teipir.softeng.controllers.EisitirioController;
import org.teipir.softeng.models.Eisitirio;

public class TestEisitiria {

	private EisitirioController eisCont =  new EisitirioController();

	@Test
	public void testAddEisitirio() {
		assertTrue(eisCont.addEisitirio("Καρπενήσι", "Πάτρα", "2015-12-14", 30, 1, 12.5));
	}
	
	@Test
	public void testGetDromologia() {
		List<Eisitirio> eisitiria = eisCont.getAllEisitiria();
		assertFalse(eisitiria.isEmpty());
	}

}
