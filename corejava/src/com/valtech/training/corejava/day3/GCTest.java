package com.valtech.training.corejava.day3;

public class GCTest {
	
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		long x = System.nanoTime();
		for (int i = 0; i < n; i++) {
//			StringBuffer sb=new StringBuffer();
//			sb.append(" ").append("i").append(" ").append("i").append(" ").append("i").toString();
			String s = " "+i+" "+i+" "+i;
//			System.gc();
		}
		long y = System.nanoTime();
		long time = (y-x)/1000000;
		System.out.println("Time Taken = "+time+" milli secs");
	}

}
