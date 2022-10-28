package valtechspring.jdbc;

import java.util.List;

import valtechspring.orm.Car;

public interface CarDAO {

	void save(Car car);

	void update(Car car);

	void delete(Car car);

	Car get(int id);

	List<Car> getAll();

}