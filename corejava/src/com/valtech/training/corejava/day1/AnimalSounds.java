package com.valtech.training.corejava.day1;

public class AnimalSounds {
	
	public void disturb(Animal a)	{
		a.makeSound();
	}
	
	public static void main(String[] args) {
		AnimalSounds as = new AnimalSounds();
		as.disturb(new Dog());
		as.disturb(new Cat());
	}

}
