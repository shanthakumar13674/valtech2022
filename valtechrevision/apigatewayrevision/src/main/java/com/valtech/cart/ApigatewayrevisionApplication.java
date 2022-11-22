package com.valtech.cart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ApigatewayrevisionApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApigatewayrevisionApplication.class, args);
	}

}
