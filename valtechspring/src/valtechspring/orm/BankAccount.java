package valtechspring.orm;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(BankAccountId.class)
public class BankAccount {
	
	@Id
	private int accountNo;
	@Id
	private String accounType;
	private float balance;
	private Date openingDate;
	private boolean active;
	
	public BankAccount() {}
	public BankAccount(int accountNo, String accounType, float balance, Date openingDate, boolean active) {
		super();
		this.accountNo = accountNo;
		this.accounType = accounType;
		this.balance = balance;
		this.openingDate = openingDate;
		this.active = active;
	}
	
	public int getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}
	public String getAccounType() {
		return accounType;
	}
	public void setAccounType(String accounType) {
		this.accounType = accounType;
	}
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
	public Date getOpeningDate() {
		return openingDate;
	}
	public void setOpeningDate(Date openingDate) {
		this.openingDate = openingDate;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	@Override
	public String toString() {
		return "BankAccount [accountNo=" + accountNo + ", accounType=" + accounType + ", balance=" + balance
				+ ", openingDate=" + openingDate + ", active=" + active + "]";
	}
}
