package com.valtech.spring.boot.service;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.spring.boot.entity.Car;

public interface CarService {

	Car createCar(Car car);

	Car updateCar(Car car);

	Car getCar(int id);

	List<Car> getAllCars();

}