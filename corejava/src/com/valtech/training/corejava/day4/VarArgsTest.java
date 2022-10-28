package com.valtech.training.corejava.day4;

import static org.junit.Assert.*;

import org.junit.Test;

public class VarArgsTest {

	@Test
	public void test() {
		VarArgs va = new VarArgs();
		assertEquals(0, va.add());
		assertEquals(2, va.add(2));
		assertEquals(3, va.add(1,2));
		assertEquals(5, va.add(0,2,3));
		assertEquals(6, va.add(1,1,2,2));
	}

}
