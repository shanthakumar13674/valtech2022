package com.valtech.spring.boot.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.spring.boot.jpa.Employee;
import com.valtech.spring.boot.jpa.EmployeeRepository;

@Service
@Transactional(propagation=Propagation.SUPPORTS)
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Transactional(propagation=Propagation.REQUIRED)
	public Employee save(Employee emp)	{
		return employeeRepository.save(emp);
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public Employee update(Employee emp){
		return employeeRepository.save(emp);
	}
	
	public Employee get(int id)	{
		return employeeRepository.getReferenceById(id);
	}
	
	public List<Employee> getAll()	{
		return employeeRepository.findAll();
	}

}
