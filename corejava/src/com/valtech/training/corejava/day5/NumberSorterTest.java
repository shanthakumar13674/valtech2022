package com.valtech.training.corejava.day5;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class NumberSorterTest {
	
	@Test
	public void testCompare()	{
		NumberSorter ns = new NumberSorter();
		assertEquals(-1, ns.compare(-1, 1));
	}

	@Test
	public void test() {
		Integer [] data = new Integer[] {57,-1,32,2,46,71,1};
		System.out.println(Arrays.asList(data));
		Arrays.sort(data,new NumberSorter());
		System.out.println(Arrays.asList(data));
		assertArrayEquals(new Integer[] {-1,1,57,71,46,32,2},data);
	}

}
