package com.valtech.spring.boot.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.valtech.spring.boot.entity.Car;
import com.valtech.spring.boot.service.CarService;

@RestController
public class CarRestController {
	
	@Autowired
	private CarService carService;
	
	@PostMapping("/api/cars")
	public Car createCar(@RequestBody Car car)	{
		return carService.createCar(car);
	}
	
	@GetMapping("/api/cars")
	public List<Car> getCars()	{
		return carService.getAllCars();
	}
	
	@GetMapping("/api/cars/{id}")
	public Car getCar(@PathVariable("id") int id)	{
		Car car= carService.getCar(id);
		return car;
	}

}



