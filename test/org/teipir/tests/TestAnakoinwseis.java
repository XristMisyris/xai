package org.teipir.tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.teipir.softeng.controllers.AnakoinwseisController;
import org.teipir.softeng.models.Anakoinwsi;

public class TestAnakoinwseis {

	private AnakoinwseisController aCont = new AnakoinwseisController();;

	@Test
	public void testGetAnakoinwseis() {
		List<Anakoinwsi> dromologia = aCont.getAllAnakoinwseis();
		assertFalse(dromologia.isEmpty());
	}

	@Test
	public void testAddAnakoinwsi() {
		assertTrue(aCont.addAnakoinwsi("Νέο Δρομολόγιο", "Προστέθηκε το Δρομολόγιο Καρπενήσι - Πάτρα."));
	}

}
