package valtechspring.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import valtechspring.jdbc.CarDAO;
import valtechspring.orm.Car;

public class JDBCTest {
	
	public static void main(String[] args) {
		ApplicationContext appCtx = new ClassPathXmlApplicationContext("jdbc.xml");
		CarDAO carDAO = (CarDAO) appCtx.getBean("carDAO");
		Car car = carDAO.get(1);
		System.out.println(car);
	}

}
