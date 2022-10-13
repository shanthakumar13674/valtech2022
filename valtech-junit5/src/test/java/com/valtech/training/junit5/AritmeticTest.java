package com.valtech.training.junit5;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AritmeticTest {
	
	private Arithmetic arithmetic;
	
	@BeforeEach
	public void runBefore()	{
		arithmetic = new ArithmeticImpl();
		System.out.println("Run Before ...");
	}
	
	public void afterTest()	{
		
	}
	
	@Test
	public void testHi()	{
		System.out.println("Hi ...");
	}
	
	@Test
	public void testHello()	{
		System.out.println("Hello ...");
	}

}
