package com.valtech.training.corejava.day2;

public class ArrayTest {
	
	public static void print(int [] arr)	{
//		System.out.println(arr.getClass().getName());
		for (int i = 0; i < arr.length; i++) {
			System.out.println("Element at "+i +" is "+arr[i]);
		}
	}
	
	public static void print(String [] arr)	{
//		System.out.println(arr.getClass().getName());
		for (int i = 0; i < arr.length; i++) {
			System.out.println("Element at "+i +" is "+arr[i]);
		}
	}
	
	public static void print(int[][] a)	{
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				System.out.println("Element at "+i+","+j+" is "+a[i][j]);
			}
		}
	}
	
	public static void main(String[] args) {
//		int [] a = new int[3];
		int [] a = new int [] {2,3,5};
		print(a);
		print(new String[] {"Hello","How","are","you"});
		int [][] i = new int[3][];
		i[0]=new int[] {2,4};
		i[1]=new int[] {3,4,5,6,7};
		i[2]=new int[0];
		print(i);
	}

}





