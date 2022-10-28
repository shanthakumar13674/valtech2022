package com.valtech.jws.config;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.valtech.jws.CarService;
import com.valtech.jws.CarWsImpl;

@Configuration
public class WebServiceConfig {
	
	@Autowired
	private Bus bus;
	
	@Bean
	public Endpoint carsService(CarService carService)	{
		EndpointImpl endPoint = new EndpointImpl(bus, new CarWsImpl(carService));
		endPoint.setAddress("/cars");
		endPoint.publish();
		return endPoint;
	}

}













