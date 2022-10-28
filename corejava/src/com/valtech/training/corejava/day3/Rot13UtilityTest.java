package com.valtech.training.corejava.day3;

import static org.junit.Assert.*;

import org.junit.Test;

public class Rot13UtilityTest {

	@Test
	public void test() {
		assertEquals('n',Rot13Utility.rotate('a'));
		assertEquals('a',Rot13Utility.rotate('n'));
		assertEquals('m',Rot13Utility.rotate('z'));
		assertEquals('z',Rot13Utility.rotate('m'));
	}

}
