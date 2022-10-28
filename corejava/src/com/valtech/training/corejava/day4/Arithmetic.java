package com.valtech.training.corejava.day4;

import com.valtech.training.corejava.day1.Point;

public class Arithmetic<E extends Number> {
	
//	public int add(int a,int b)
	
	public <F> void print(F obj)	{
		System.out.println("Recd ... Class "+obj.getClass().getName()+" "+obj);
	}
	
	public double add(E a,E b) {
		return a.doubleValue()+b.doubleValue();
	}
	
	public static void main(String[] args) {
		Arithmetic<Integer> a = new Arithmetic<>();
		System.out.println(a.add(2, 3));
		System.out.println(new Arithmetic<Double>().add(2.3, 4.6));
		a.print("HEllo");
		a.print(5);
		
//		System.out.println(new Arithmetic<Point>().add(new Point(2,3),new Point(3,5)));
	}

}
