package no.hvl.dat108;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestMyServlet1 {

	
	/**
	 * Tester om vår regex fungerer som den skal med 5 eksempler som er både sann og usann
	 * @throws Exception
	 */
	@Test
	public void sanity() throws Exception {
		String regex = "^\\S+(?: \\S+)*$";
		String input1 = "Banan";
		String input2 = "         Banan";
		String input3 = " ";
		String input4 = "";
		String input5 = "3 Bananer";
		
		assertTrue(input1.matches(regex));
		assertTrue(input5.matches(regex));
		assertFalse(input2.matches(regex));
		assertFalse(input3.matches(regex));
		assertFalse(input4.matches(regex));
		
		
	}



}
