package com.valtech.jwsclient;

import javax.xml.namespace.QName;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.valtech.jws.CarWs;


@Configuration
public class WebServiceClientConfig {
	
	@Bean
	public CarWs createCarWsClientProxy()	{
		JaxWsProxyFactoryBean proxy = new JaxWsProxyFactoryBean();
		proxy.setServiceClass(CarWs.class);
		proxy.setServiceName(new QName("http://jws.valtech.com/", "CarWsImplService"));
		proxy.setAddress("http://localhost:8080/services/cars");
		return proxy.create(CarWs.class);
	}

}
