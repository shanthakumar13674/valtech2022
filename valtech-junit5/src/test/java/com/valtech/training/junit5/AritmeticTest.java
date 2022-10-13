package com.valtech.training.junit5;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class AritmeticTest {
	
	private Arithmetic arithmetic;
	private static int ZERO;
	
	@ParameterizedTest
	@ValueSource(ints = {2,3,4,-1,-2})
	public void testAddZero(int a) {
		assertEquals(a, arithmetic.add(a, ZERO));
	}
	
	@Test
	public void testAdd()	{
		assertEquals(5, arithmetic.add(2, 3));
		assertEquals(5, arithmetic.add(3, 2));
	}
	
	@BeforeAll
	public static void executeMeFirst()	{
		System.out.println("Before All - Executed First....");
		ZERO=0;
	}
	
	@AfterAll
	public static void executeMeJustBeforeProgramExits()	{
		System.out.println("Last Method to be executed...");
	}
	
	@BeforeEach
	public void runBefore()	{
		arithmetic = new ArithmeticImpl();
		System.out.println("Run Before ...");
	}
	
	@AfterEach
	public void afterTest()	{
		System.out.println("After Each Method");
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
