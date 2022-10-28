package valtechspring.orm;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Account {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private double balance;
	private String accountType;
	@OneToMany(targetEntity=Tx.class,cascade={CascadeType.MERGE,CascadeType.PERSIST},fetch=FetchType.LAZY,mappedBy="account")
	private Set<Tx> txs;
	@ManyToMany(targetEntity=Customer.class,cascade={CascadeType.MERGE,CascadeType.PERSIST})
	@JoinTable(name="customer_account",joinColumns=@JoinColumn(name="account_id",referencedColumnName="id"),
	inverseJoinColumns=@JoinColumn(name="customer_id",referencedColumnName="id"))
	private Set<Customer> customers;
	
	public Account(){}
	public Account(double balance, String accountType) {
		super();
		this.balance = balance;
		accountType = accountType;
	}
	
	public void setCustomers(Set<Customer> customers) {
		this.customers = customers;
	}
	public Set<Customer> getCustomers() {
		return customers;
	}
	public void setTxs(Set<Tx> txs) {
		this.txs = txs;
	}
	public Set<Tx> getTxs() {
		return txs;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		accountType = accountType;
	}
}
