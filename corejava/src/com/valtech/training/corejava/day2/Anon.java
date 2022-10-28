package com.valtech.training.corejava.day2;

import com.valtech.training.corejava.day1.Animal;

public class Anon {

	public static void main(String[] args) {
		Animal a = new Animal() {
			
			int counter =0;

			public void makeSound() {
				counter ++;
				System.out.println("Anon... "+counter);
			}
			
		};
		a.makeSound();
		a.makeSound();
	}

}
