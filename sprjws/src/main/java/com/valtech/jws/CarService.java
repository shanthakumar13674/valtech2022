package com.valtech.jws;

import java.util.List;

public interface CarService {

	void saveCar(Car car);

	void updateCar(Car car);

	void deleteCar(Car car);

	Car getCar(int id);

	List<Car> getAllCars();

}