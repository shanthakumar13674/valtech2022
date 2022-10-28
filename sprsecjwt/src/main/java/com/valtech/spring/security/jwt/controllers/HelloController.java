package com.valtech.spring.security.jwt.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@GetMapping("/admin")
	@PreAuthorize("hasRole('ADMIN')")
	public String admin()	{
		return "Hello Admin";
	}
	
	@GetMapping("/user")
	@PreAuthorize("hasRole('USER')")
	public String user()	{
		return "Hello User";
	}
	
	@GetMapping("/hello")
	public String hello()	{
		return "Hello";
	}
//	http://localhost8080/hello

}
