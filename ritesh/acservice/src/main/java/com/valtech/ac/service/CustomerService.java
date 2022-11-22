package com.valtech.ac.service;

import java.util.List;

import com.valtech.ac.entity.Customer;

public interface CustomerService {

	Customer createCustomer(Customer cus);

	Customer updateCustomer(Customer cus);

	Customer getCustomer(long id);

	List<Customer> getAllCustomers();

}