package com.valtech.account.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Account {
	
	public static final String SAVINGS = "SB";
	public static final String CURRENT = "CA";
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String accountType;
	private double balance;
	private LocalDateTime creationDate;
	private LocalDateTime lastUpdatedDate;
	private boolean active;
	
	public Account(){}
	public Account(long id, String accountType, double balance, LocalDateTime creationDate, LocalDateTime lastUpdatedDate,
			boolean active) {
		this.id = id;
		this.accountType = accountType;
		this.balance = balance;
		this.creationDate = creationDate;
		this.lastUpdatedDate = lastUpdatedDate;
		this.active = active;
	}
	public Account(String accountType, double balance) {
		this.accountType = accountType;
		this.balance = balance;
		this.creationDate = LocalDateTime.now();
		this.lastUpdatedDate = LocalDateTime.now();
		this.active = false;
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
