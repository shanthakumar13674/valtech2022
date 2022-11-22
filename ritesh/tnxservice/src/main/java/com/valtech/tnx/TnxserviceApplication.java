package com.valtech.tnx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class TnxserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TnxserviceApplication.class, args);
	}

}
