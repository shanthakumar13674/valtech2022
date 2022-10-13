package com.valtech.training;

import static org.junit.Assert.*;

import org.junit.Test;

public class ArithmeticImplTest {

	@Test
	public void testAdd() {
		Arithmetic a = new ArithmeticImpl();
		assertEquals(5, a.add(2, 3));
	}
	
	@Test
	public void testSub() {
		Arithmetic a = new ArithmeticImpl();
		assertEquals(-1, a.sub(2, 3));
	}
	
	@Test
	public void testMul() {
		Arithmetic a = new ArithmeticImpl();
		assertEquals(6, a.mul(2, 3));
	}
	@Test
	public void testDiv() {
		Arithmetic a = new ArithmeticImpl();
		assertEquals(0, a.div(2, 3));
	}

}
