package com.pos.icecream.view;

import junit.framework.TestCase;


public class AdminPanelTest extends TestCase {
	private AdminPanel ap =null;

	public void setUp() throws Exception {
		ap = new AdminPanel();
	}

	public void testIsValidDescription() {

		assertEquals(false, ap.isValidDescription(null));
		assertEquals(false, ap.isValidDescription(""));
		
		assertEquals(true, ap.isValidDescription("ice"));
		assertEquals(true, ap.isValidDescription("1"));
	}

	public void testIsValidPrice() {
		
		assertEquals(false, ap.isValidPrice(null));
		assertEquals(false, ap.isValidPrice(""));
		assertEquals(false, ap.isValidPrice("ice"));
		assertEquals(false, ap.isValidPrice("one"));
		assertEquals(false, ap.isValidPrice("-1"));
		assertEquals(false, ap.isValidPrice("1.0.1"));
		
		assertEquals(true, ap.isValidPrice("1"));
		assertEquals(true, ap.isValidPrice("1.1"));
		assertEquals(true, ap.isValidPrice("100"));
		
//		fail("Not yet implemented");
	}

}
