package com.valtech.spring.boot.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	List<Employee> findByName(String name);
	List<Employee> findByGender(int gender);
	List<Employee> findByNameAndGender(String name,int genfer);
	List<Employee> findByNameOrGender(String name,int genfer);
	List<Employee> findBySalaryBetween(float minSal,float maxSal);
	
	long countByName(String name);
	long countByGender(int gender);
	long countByNameOrGender(String name,int gender);
	long countByNameAndGender(String name,int gender);
	long countBySalaryBetween(float minSal,float maxSal);

}
