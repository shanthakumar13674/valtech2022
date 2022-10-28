package com.valtech.training.corejava.day5;

import java.util.Comparator;

public class CustomStringSorter implements Comparator<String> {
	
	public int vowelCount(String str)	{
		String vowels = "AaEeIiOoUu";
		int count = 0;
		for(int i=0;i<str.length();i++) {
			if(vowels.contains(""+str.charAt(i)))	{
				count++;
			}
		}
		return count;
	}
	
	
	@Override
	public int compare(String o1, String o2) {
		int l1 = o1.length();
		int l2 = o2.length();
		if(l1 < l2) return -1;
		if(l1 > l2) return +1;
		l1 = vowelCount(o1);
		l2 = vowelCount(o2);
		if(l1 < l2) return -1;
		if(l1 > l2) return +1;
		return o1.compareTo(o2);
	}

}









