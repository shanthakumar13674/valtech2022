package com.valtech.spring.boot.service;

import java.util.List;

import com.valtech.spring.boot.jpa.Employee;

public interface EmployeeService {

	Employee save(Employee emp);

	Employee update(Employee emp);

	Employee get(int id);

	List<Employee> getAll();

}