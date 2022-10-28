package valtechspring.tx;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import valtechspring.jdbc.CarDAO;
import valtechspring.orm.Car;

public class CarServiceImpl implements CarService {
	
	private CarDAO carDAO;
	
	public void setCarDAO(CarDAO carDAO) {
		this.carDAO = carDAO;
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public void updatePrice(int carId,float price)	{
		Car car = carDAO.get(carId);
		car.setPrice(price);
		carDAO.update(car);
//		throw new RuntimeException("No Changes should be made");
	}

}
