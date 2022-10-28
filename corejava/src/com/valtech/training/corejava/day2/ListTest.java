package com.valtech.training.corejava.day2;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.junit.Test;

public class ListTest {
	
	@Test
	public void testStackAndQueue()	{
//		Stack<String> animals = new Stack<>();
		Queue<String> animals = new LinkedList<>();
		animals.add("Dog");
		animals.add("Cat");
		animals.add("Cow");
		assertEquals(3, animals.size());
		System.out.println(animals.remove());
		System.out.println(animals.remove());
		assertEquals(1, animals.size());
	}

	@Test
	public void test() {
		List<String> names = new LinkedList<>();
		names.add("Hello1");
		names.add("Hello2");
		names.add("Hello3");
		names.add(0,"Hello4");
		names.add("Hi");
		assertEquals(5, names.size());
		for (Iterator iterator = names.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			System.out.println(string);
		}
	}

}
