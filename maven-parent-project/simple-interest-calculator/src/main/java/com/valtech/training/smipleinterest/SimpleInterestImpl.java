package com.valtech.training.smipleinterest;

import com.valtech.training.Arithmetic;
import com.valtech.training.ArithmeticImpl;

public class SimpleInterestImpl implements SimpleInterest {
	
	private Arithmetic arithmetic = new ArithmeticImpl();
	
	@Override
	public int computeInterest(int prin, int roi, int time) {
		int total = arithmetic.mul(prin, roi);
		total = arithmetic.mul(total, time);
		return arithmetic.div(total, 100);
//		return arithmetic.div(arithmetic.mul(roi,arithmetic.mul(prin, time)), 100);
	}
	

}
