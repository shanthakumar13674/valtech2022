package com.valtech.training.corejava.day1;

public class Outer {
	
	private int x = 5;
	
	private void printY(Inner i)	{
		System.out.println("Y = "+i.y);
	}
	
	private static class Inner	{
		
		private int y = 5;
		
		void printX(Outer o)	{
			System.out.println("X = "+o.x);
		}
		
		public void increment(Outer o) {
			o.x++;
		}
		
	}
	
	public static void main(String[] args) {
		Outer o = new Outer();
		Inner i = new Inner();
		o.printY(i);
		i.printX(o);
		i.increment(o);
		new Inner().increment(o);
		i.printX(o);
		i.printX(new Outer());
		
	}

}









