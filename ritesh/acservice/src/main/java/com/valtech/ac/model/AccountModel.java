package com.valtech.ac.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.valtech.ac.entity.Account;

public class AccountModel {
	
	private long id;
	private String accountType;
	private double balance;
	private LocalDateTime creationDate;
	private LocalDateTime lastUpdatedDate;
	private boolean active;
	private List<TxModel> txs=new ArrayList<>();
	
//	Active When the TX-SERVICE is not available
	private boolean validRequest;
	private String messageForFailure;
	

	public AccountModel(){}
	
	public AccountModel(Account acc)	{
		this(acc.getId(),acc.getAccountType(),acc.getBalance(),
				acc.getCreationDate(),acc.getLastUpdatedDate(),acc.isActive());
	}
	
	public AccountModel(String accountType, double balance) {
		this.accountType = accountType;
		this.balance = balance;
	}
	public AccountModel(long id, String accountType, double balance, LocalDateTime creationDate,
			LocalDateTime lastUpdatedDate, boolean active) {
		this.id = id;
		this.accountType = accountType;
		this.balance = balance;
		this.creationDate = creationDate;
		this.lastUpdatedDate = lastUpdatedDate;
		this.active = active;
	}

	public Account getAccount()	{
		return new Account(id,accountType,balance,creationDate,
				lastUpdatedDate,active);
	}
	
	public boolean getValidRequest() {
		return validRequest;
	}

	public void setValidRequest(boolean validRequest) {
		this.validRequest = validRequest;
	}

	public String getMessageForFailure() {
		return messageForFailure;
	}

	public void setMessageForFailure(String messageForFailure) {
		this.messageForFailure = messageForFailure;
	}

	@Override
	public String toString() {
		return "AccountModel [id=" + id + ", accountType=" + accountType + ", balance=" + balance + ", creationDate="
				+ creationDate + ", lastUpdatedDate=" + lastUpdatedDate + ", active=" + active + "]";
	}

	public List<TxModel> getTxs() {
		return txs;
	}
	public void setTxs(List<TxModel> txs) {
		this.txs = txs;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public LocalDateTime getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}
	public LocalDateTime getLastUpdatedDate() {
		return lastUpdatedDate;
	}
	public void setLastUpdatedDate(LocalDateTime lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
}
