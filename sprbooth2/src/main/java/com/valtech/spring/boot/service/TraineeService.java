package com.valtech.spring.boot.service;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.spring.boot.jpa.Trainee;

public interface TraineeService {

	Trainee get(int id);

	void delete(Trainee trainee);

	Trainee update(Trainee trainee);

	Trainee save(Trainee trainee);

	List<Trainee> getAllBySalaryGT(float salary);

}