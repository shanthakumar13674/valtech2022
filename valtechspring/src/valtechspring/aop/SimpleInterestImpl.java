package valtechspring.aop;

public class SimpleInterestImpl implements SimpleInterest {
	
	private Arithmetic arithmetic;
	
	public SimpleInterestImpl(){}
	public SimpleInterestImpl(Arithmetic arihmetic)	{
		this.arithmetic = arihmetic;
	}
	
	public void setArithmetic(Arithmetic arihmetic) {
		this.arithmetic = arihmetic;
	}
	
	@Override
	public int computeSimpleInterest(int principal, int time, int rateOfInterest)	{
		return arithmetic.div(arithmetic.mul(principal,time,rateOfInterest),100);
	}

}
