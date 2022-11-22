package com.valtech.tnx.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("wtx")
public class WithdrawlTx extends Tx{
	private int atmNo;
	private String location;
	private float amount;
	public WithdrawlTx() {}
	public WithdrawlTx(float amount,int atmNo, String location) {
		super(amount);
		this.amount=amount;
		this.atmNo = atmNo;
		this.location = location;
	}
	public int getAtmNo() {
		return atmNo;
	}
	public void setAtmNo(int atmNo) {
		this.atmNo = atmNo;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "AtmTx [atmNo=" + atmNo + ", location=" + location + ", amount=" + amount + "]";
	}

}
