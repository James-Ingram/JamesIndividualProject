package com.qa.rest;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class JAXActivatorTest {

	public JAXActivatorTest() {
	}
	
	@Test
	public void testActivator() {
		JAXActivator jax = new JAXActivator();
		assertEquals(jax, jax);
	}
	
}
