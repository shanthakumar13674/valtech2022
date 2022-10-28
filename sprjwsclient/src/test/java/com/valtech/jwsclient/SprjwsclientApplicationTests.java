package com.valtech.jwsclient;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.valtech.jws.Car;
import com.valtech.jws.CarWs;

@SpringBootTest
class SprjwsclientApplicationTests {
	
	@Autowired
	private CarWs carWs;

	@Test
	void testCarWs() {
//		assertEquals(0,carWs.getAllCars().size()); // will work only once..
		int count = carWs.getAllCars().size();
		carWs.saveCar(new Car(2,"Honda","Jazz",2019,"Silver",900000));
		assertEquals(count+1, carWs.getAllCars().size());
		System.out.println(carWs.getAllCars());
	}

}
