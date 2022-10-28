package com.valtech.spring.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.spring.boot.jpa.Trainee;
import com.valtech.spring.boot.repository.TraineeRepository;

@Service
public class TraineeServiceImpl implements TraineeService {

	@Autowired
	private TraineeRepository traineeRepository;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Trainee get(int id)	{
		return traineeRepository.getReferenceById(id);
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void delete(Trainee trainee)	{
		 traineeRepository.delete(trainee);
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public Trainee update(Trainee trainee)	{
		return traineeRepository.save(trainee);
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public Trainee save(Trainee trainee)	{
		return traineeRepository.save(trainee);
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<Trainee> getAllBySalaryGT(float salary) {
		return traineeRepository.findBySalaryGreaterThan(salary);
	}

}
