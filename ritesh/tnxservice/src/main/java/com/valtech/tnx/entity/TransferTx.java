package com.valtech.tnx.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("ttx")
public class TransferTx extends Tx{
	private long accountFrom;
	private long accountTo;
	private String branch;
	private float amount;
	public TransferTx(){}
	public TransferTx(float amount,long accountFrom, long accountTo, String branch) {
		super(amount);
		this.amount=amount;
		this.accountFrom = accountFrom;
		this.accountTo = accountTo;
		this.branch = branch;
	}
	public long getAccountFrom() {
		return accountFrom;
	}
	public void setAccountFrom(long accountFrom) {
		this.accountFrom = accountFrom;
	}
	public long getAccountTo() {
		return accountTo;
	}
	public void setAccountTo(long accountTo) {
		this.accountTo = accountTo;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	@Override
	public String toString() {
		return "TransferTx [accountFrom=" + accountFrom + ", accountTo=" + accountTo + ", branch=" + branch + "]";
	}
	

}
