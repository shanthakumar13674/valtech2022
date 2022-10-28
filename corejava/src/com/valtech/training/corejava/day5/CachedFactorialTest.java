package com.valtech.training.corejava.day5;

import static org.junit.Assert.*;

import org.junit.Test;

public class CachedFactorialTest {

	@Test
	public void test() {
		CachedFactorial cf = new CachedFactorial();
		assertEquals(6, cf.factorial(3));
		cf.dump();
		assertEquals(120,cf.factorial(5));
		cf.dump();
		assertEquals(120,cf.factorial(5));
		cf.dump();
	}

}
