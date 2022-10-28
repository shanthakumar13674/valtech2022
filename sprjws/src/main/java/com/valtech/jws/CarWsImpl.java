package com.valtech.jws;

import java.util.List;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;

@WebService(endpointInterface="com.valtech.jws.CarWs",name="CarsService",portName="CarsPort")
public class CarWsImpl implements CarWs {
	
	private CarService carService;
	
	public CarWsImpl(CarService carService) {
		this.carService=carService;
	}

	@Override
	public void saveCar(Car car) {
		carService.saveCar(car);
	}

	@Override
	public void updateCar(Car car) {
		carService.updateCar(car);
	}

	@Override
	public void deleteCar(Car car) {
		carService.deleteCar(car);
	}

	@Override
	public Car getCar(int id) {
		return carService.getCar(id);
	}

	@Override
	public List<Car> getAllCars() {
		return carService.getAllCars();
	}
	
}
