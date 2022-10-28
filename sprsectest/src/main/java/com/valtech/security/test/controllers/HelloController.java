package com.valtech.security.test.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@GetMapping("/hello")
	public String hello()	{
		return "Hello";
	}
	
	@GetMapping("/user")
	public String user()	{
		return "Hello User";
	}
	
	@GetMapping("/admin")
	public String admin()	{
		return "Hello Admin";
	}
	
}
