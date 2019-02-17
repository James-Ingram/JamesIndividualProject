package com.qa.rest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
