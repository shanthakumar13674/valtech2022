package com.valtech.spring.boot;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.valtech.spring.boot.jpa.Employee;
import com.valtech.spring.boot.jpa.EmployeeRepository;

@SpringBootTest
class SprbootApplicationTests {
	
	@Autowired
	private HelloWorld helloWorld;

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Test
	void testHelloWorld()	{
		assertEquals("Hello Valtech",helloWorld.hello("Valtech"));
	}
	
	@Test
	void testFinders()	{
		assertEquals(2, employeeRepository.countByGender(1));
		assertEquals(1, employeeRepository.countByGender(0));
		assertEquals(1, employeeRepository.countByGender(-1));
		assertEquals(2, employeeRepository.countBySalaryBetween(14000, 20000));
	}

	@Test
	void testEmployeeRepo() {
		long count = employeeRepository.count();
//		Employee emp = new Employee("Def",-1,LocalDate.of(1974, 8, 15),12000,"JP Nagar, Bangalore, 560078");
//		employeeRepository.save(emp);
//		emp = new Employee("Xyz",1,LocalDate.of(1974, 8, 15),12000,"JP Nagar, Bangalore, 560078");
//		employeeRepository.save(emp);
//		emp = new Employee("Lmn",0,LocalDate.of(1974, 8, 15),12000,"JP Nagar, Bangalore, 560078");
//		employeeRepository.save(emp);
//		assertEquals(count+3, employeeRepository.count());
	}

}






