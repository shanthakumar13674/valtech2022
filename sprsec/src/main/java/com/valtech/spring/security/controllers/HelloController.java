package com.valtech.spring.security.controllers;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.valtech.spring.security.model.RegisterUserModel;
import com.valtech.spring.security.service.ValtechUserDetailsService;

@Controller
public class HelloController {
	
	@Autowired 
	private ValtechUserDetailsService userDetailsManager;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@GetMapping("/resetUsers")
	@ResponseBody
	public String resetUsers()	{
		System.out.println(userDetailsManager.loadUserByUsername("scott"));
		System.out.println(userDetailsManager.loadUserByUsername("admin"));
		userDetailsManager.resetUsers();
		com.valtech.spring.security.entity.User user = new com.valtech.spring.security.entity.User("scott",passwordEncoder.encode("tiger"));
		user.setRoles(Arrays.asList("USER"));
		user.setEnabled(true);
		userDetailsManager.createUser(user);
		user = new com.valtech.spring.security.entity.User("admin",passwordEncoder.encode("admin"));
		user.setRoles(Arrays.asList("USER","ADMIN"));
		user.setEnabled(true);
		userDetailsManager.createUser(user);
		return "Success";
	}
	
	@GetMapping("/login")
	public String login()	{
		return "login";
	}
	
	@PostMapping("/register")
	public String registerUser(@ModelAttribute RegisterUserModel registerUserModel)	{
		String username = registerUserModel.getUsername();
		String password = registerUserModel.getPassword();
		String confirmPassword = registerUserModel.getConfirmpassword();
		if(password.equals(confirmPassword))	{
			userDetailsManager.createUser(User.withUsername(username).password(password).roles("USER").build());
			return "login";
		}	else	{
			return "register";
		}
		
	}
	
	@GetMapping("/register")
//	@ResponseBody
	public String register()	{
		return "register";
	}
	
	@GetMapping("/admin")
//	@ResponseBody
	public String adminPages(){
		return "admin/home";
	}
	
	@GetMapping("/user")
//	@ResponseBody
	public String userPages()	{
		return "user/home";
	}
	
	@GetMapping("/")
	@ResponseBody
	public String index()	{
		return "Success";
	}

}
