package com.valtech.jws;

import java.util.List;

import javax.jws.WebService;

@WebService
public interface CarWs {

	void saveCar(Car car);

	void updateCar(Car car);

	void deleteCar(Car car);

	Car getCar(int id);

	List<Car> getAllCars();

}