package com.valtech.jws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarServiceImpl implements CarService {

	@Autowired
	private CarDAO carDAO;

	@Override
	public void saveCar(Car car) {
		carDAO.saveCar(car);
	}

	@Override
	public void updateCar(Car car) {
		carDAO.updateCar(car);
	}

	@Override
	public void deleteCar(Car car) {
		carDAO.deleteCar(car);
	}

	@Override
	public Car getCar(int id) {
		return carDAO.getCar(id);
	}

	@Override
	public List<Car> getAllCars() {
		return carDAO.getAllCars();
	}
	
}
