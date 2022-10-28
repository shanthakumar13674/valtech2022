package com.valtech.training.corejava.day5;

import java.util.ArrayList;
import java.util.List;

public class CachedFactorial {
	
	List<Long> cache = new ArrayList<>();
	
	public void dump() {
		System.out.println(cache);
	}
	
	public long factorial(int n)	{
		// check size of list
		// size is > n then return the element
		if(cache.size() >= n)	{
			System.out.println("Returning from cache...");
			return cache.get(n-1);
		}
		// size is less
		// compute the factorials from size to n
		if(n == 1) {
			cache.add(1L);
			return 1;
		}
		long fact = factorial(n-1);
		long factn = n * fact;
		cache.add(factn);
		return factn;
		// store all factorials btw size to n 
		// return factorial from the list
	}

}
