package com.valtech.jws;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

@Component
public class CarDAO {
	
	private Map<Integer, Car> cars;
	
	{
		cars = new HashMap<Integer, Car>();
	}
	
	public void saveCar(Car car)	{
		cars.put(car.getId(), car);
		System.out.println("Sucessfully Saved Car with id "+car.getId());
	}

	public void updateCar(Car car)	{
		cars.put(car.getId(), car);
		System.out.println("Sucessfully Updated Car with id "+car.getId());
	}
	
	public void deleteCar(Car car)	{
		cars.remove(car.getId());
		System.out.println("Sucessfully Deleted Car with id "+car.getId());
	}
	
	public Car getCar(int id)		{
		System.out.println("Sucessfully Loaded Car with id "+id);
		return cars.get(id);
	}
	
	public List<Car> getAllCars()	{
		System.out.println("Sucessfully loaded all cars ");
		return cars.values().stream().collect(Collectors.toList());
	}
	
}
