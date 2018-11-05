package no.hvl.dat108;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestRegexp {

	
	/**
	 * Tester om vår regex fungerer som den skal med 3 eksempler som er både sann og usann for alle regexp
	 * @throws Exception
	 */
	@Test
	public void sanity() throws Exception {
		String regexMobil = "^[0-9]{8,8}$";
		String regexNavn = "([A-ZÆØÅ][A-Za-z æøå-]{1,20})";
		String regexPassord = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$";
		String inputP1 = "mmm999**";
		String inputP2 = "mm99";
		String inputP3 = "jgregoe346";
		String inputN1 = "Fred1";
		String inputN2 = "Arne";
		String inputN3 = "fere";
		String inputM1 = "98989898";
		String inputM2 = "999999999";
		String inputM3 = "3Bananer";
		
		assertTrue(inputM1.matches(regexMobil));
		assertFalse(inputM2.matches(regexMobil));
		assertFalse(inputM3.matches(regexMobil));
		
		assertTrue(inputN2.matches(regexNavn));
		assertFalse(inputN1.matches(regexNavn));
		assertFalse(inputN3.matches(regexNavn));
		
		assertTrue(inputP1.matches(regexPassord));
		assertFalse(inputP2.matches(regexPassord));
		assertFalse(inputP3.matches(regexPassord));
		
	}



}
