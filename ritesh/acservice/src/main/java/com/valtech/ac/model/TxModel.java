package com.valtech.ac.model;

import java.time.LocalDateTime;

public class TxModel {
	
	private long id;
	private float amount;
	private boolean debit;
	private LocalDateTime txTime;
	private long accountId;
	
	public TxModel(){}
	public TxModel(long id, float amount, boolean debit, LocalDateTime txTime, long accountId) {
		super();
		this.id = id;
		this.amount = amount;
		this.debit = debit;
		this.txTime = txTime;
		this.accountId = accountId;
	}
	@Override
	public String toString() {
		return "TxModel [id=" + id + ", amount=" + amount + ", debit=" + debit + ", txTime=" + txTime + ", accountId="
				+ accountId + "]";
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public boolean isDebit() {
		return debit;
	}
	public void setDebit(boolean debit) {
		this.debit = debit;
	}
	public LocalDateTime getTxTime() {
		return txTime;
	}
	public void setTxTime(LocalDateTime txTime) {
		this.txTime = txTime;
	}
	public long getAccountId() {
		return accountId;
	}
	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}
}
