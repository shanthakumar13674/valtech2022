package com.valtech.training.corejava.day5;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class CustomStringSorterTest {
	
	@Test
	public void testAlphabeticOrder()	{
		String [] names = {"Abc","Pqr","Lmno","Too","Abz","z"};
		Arrays.sort(names,new CustomStringSorter());
		assertArrayEquals(new String[]{"z","Pqr","Abc","Abz","Too","Lmno"}, names);
	}
	
	@Test
	public void testVowelCount()	{
		String [] names = {"Abc","Pqr","Lmno","Too","Ab","z"};
		Arrays.sort(names,new CustomStringSorter());
		assertArrayEquals(new String[]{"z","Ab","Pqr","Abc","Too","Lmno"}, names);
	}

	@Test
	public void testLength() {
		String [] names = {"Abc","Pqr","Lmno","Ab","z"};
		Arrays.sort(names,new CustomStringSorter());
		assertArrayEquals(new String[]{"z","Ab","Pqr","Abc","Lmno"}, names);
	}

}
