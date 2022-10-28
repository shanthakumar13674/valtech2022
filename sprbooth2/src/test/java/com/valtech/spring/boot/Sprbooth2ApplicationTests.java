package com.valtech.spring.boot;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.valtech.spring.boot.jpa.Trainee;
import com.valtech.spring.boot.repository.TraineeRepository;

@SpringBootTest
class Sprbooth2ApplicationTests {
	
	@Autowired
	private TraineeRepository traineeRepository;

	@Test
	void testFinders() {
//		traineeRepository.save(new Trainee("Abc","abc@abc.com",1,LocalDate.of(1974, 6, 10),25000));
//		traineeRepository.save(new Trainee("Def","Def@abc.com",-1,LocalDate.of(1975, 5, 12),22000));
//		traineeRepository.save(new Trainee("Lmn","Lmn@abc.com",1,LocalDate.of(1977, 5, 15),15000));
//		traineeRepository.save(new Trainee("Xyz","Xyz@abc.com",0,LocalDate.of(1974, 4, 1),20000));
//		traineeRepository.save(new Trainee("Pqr","Pqr@abc.com",-1,LocalDate.of(1975, 5, 3),24000));

		assertEquals(6, traineeRepository.findBySalaryGreaterThan(23000).size());
	}	
	

}
