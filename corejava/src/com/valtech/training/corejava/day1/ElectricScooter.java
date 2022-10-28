package com.valtech.training.corejava.day1;

public class ElectricScooter extends Vechile{

	@Override
	public void accelerate() {
		System.out.println("More Power to the Motor...");
	}

	@Override
	public void applyBrakes() {
		System.out.println("Cutoff Power to the Motor...");
		
	}

}
