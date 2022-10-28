package com.valtech.spring.boot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valtech.spring.boot.jpa.Trainee;

@Repository
public interface TraineeRepository extends JpaRepository<Trainee,Integer>	{
	
	List<Trainee> findByGender(int gender);
	
	List<Trainee> findBySalaryGreaterThan(float salary);
	

}
