package com.valtech.spring.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.valtech.spring.boot.jpa.Trainee;
import com.valtech.spring.boot.service.TraineeService;

@Controller
public class TrainerController {
	
	@Autowired
	private TraineeService traineeService;
	
	@GetMapping("/traineeBySalary")
	@ResponseBody
	public List<Trainee> listBySalary(@RequestParam("salary") float salary)	{
		return traineeService.getAllBySalaryGT(salary);
	}

}
