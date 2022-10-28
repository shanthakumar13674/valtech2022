package com.valtech.spring.boot;

import org.springframework.stereotype.Component;

@Component
public class HelloWorld {
	
	public String hello(String name)	{
		return "Hello "+name;
	}

}
