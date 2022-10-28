package com.valtech.dao;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class EmployeeDAOTest {
	
	@Test
	public void testUpdateEmployee()throws Exception	{
		EmployeeDAO dao= new EmployeeDAO();
		dao.updateEmployee(new Employee(3,"New Three",25,1,121212));
		Employee e = dao.getEmployee(3);
		assertEquals(e.getId(), 3);
		assertEquals(e.getName(),"New Three");
		assertEquals(25, e.getAge());
		assertEquals(1, e.getGender());
		assertEquals(121212, e.getSalary(),0.0000001);
	}
	
	@Test
	public void testGetEmployees()throws Exception	{
		EmployeeDAO dao = new EmployeeDAO();
		assertEquals(dao.count(),dao.getEmployees().size());
	}
	
	@Test
	public void testGetEmployee()throws Exception	{
		EmployeeDAO dao = new EmployeeDAO();
		Employee e = dao.getEmployee(1);
		assertEquals(1, e.getId());
		assertEquals(23, e.getAge());
	}

	@Test
	public void testSaveEmployee()throws Exception {
		EmployeeDAO dao = new EmployeeDAO();
		int count = dao.count();
		dao.saveEmployee(new Employee(4,"Four",27,0,10000));
		assertEquals(count+1, dao.count());
		dao.deleteEmployee(4);
		assertEquals(count, dao.count());
	}

}









