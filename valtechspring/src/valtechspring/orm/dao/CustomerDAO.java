package valtechspring.orm.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import valtechspring.orm.Customer;

public interface CustomerDAO {
	
	List<Customer> getByAccountType(Session session,String type);
	
	double getCombinedBalance(Session session,int cid);
	
	List<Customer> getByState(Session session, String state);

	List<Customer> getAllCustomers(Session session);

	Customer getCustomer(Session session, int id);

	List<Customer> getByAccountBalanceGreaterThan(Session session, double balance);

	List<Customer> getByTxAmountGreaterThan(Session session, float amount);

}