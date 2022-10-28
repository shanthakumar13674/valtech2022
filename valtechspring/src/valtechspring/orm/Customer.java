package valtechspring.orm;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQueries({@NamedQuery(name="customersByAccountType"
,query="SELECT DISTINCT c FROM Customer c JOIN c.accounts a WHERE a.accountType = ?")})
public class Customer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) // SEQUENCE for you..
	private int id;
	private String name;
	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;
	private int gender;
	@OneToOne(targetEntity=Address.class,cascade={CascadeType.MERGE,CascadeType.PERSIST},mappedBy="customer")
	private Address address;
	@ManyToMany(targetEntity=Account.class,cascade={CascadeType.MERGE,CascadeType.PERSIST},mappedBy="customers")
	private Set<Account> accounts;
	
	public Customer(){}
	public Customer(String name, Date dateOfBirth, int gender) {
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
	}
	
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", dateOfBirth=" + dateOfBirth + ", gender=" + gender
				+ ", address=" + address + "]";
	}
	public void addAccount(Account ac)	{
		if(getAccounts() == null)	{
			accounts = new HashSet<Account>();
		}
		accounts.add(ac);
		if(ac.getCustomers() == null)	{
			ac.setCustomers(new HashSet<Customer>());
		}
		ac.getCustomers().add(this);
	}
	
	public void setAccounts(Set<Account> accounts) {
		this.accounts = accounts;
	}
	public Set<Account> getAccounts() {
		return accounts;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
}
