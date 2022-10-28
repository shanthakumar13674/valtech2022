package com.valtech.spring.security.jwt.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class LoginFilter extends OncePerRequestFilter	{
	
	private UserDetailsManager userDetailsManager;
	private PasswordEncoder passwordEncoder;
	private JWTHelper jwtHelper;
	
	public LoginFilter(UserDetailsManager userDetailsManager,PasswordEncoder passwordEncoder,JWTHelper jwtHelper)	{
		this.userDetailsManager = userDetailsManager;
		this.passwordEncoder = passwordEncoder;
		this.jwtHelper = jwtHelper;
	}
	
 	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String name = request.getHeader("username");
		String pass = request.getHeader("password");// Check Username password for null then return 401
		UserDetails user = userDetailsManager.loadUserByUsername(name); // If this fails then 401
		System.out.println(user.getPassword()+"" +pass);
		if(passwordEncoder.matches(pass, user.getPassword()))	{
			response.setHeader(HttpHeaders.AUTHORIZATION,jwtHelper.createToken(user));
		}// Then 401 Msg = Username Password not valid	
		else	{
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
			response.getWriter().print("Username Password Not Valid");
		}
	}
	
	@Override
	protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
		String method = request.getMethod();
		String uri = request.getRequestURI();
		boolean login = "POST".equals(method) && uri.startsWith("/login");
		return !login; // not of login
	}
	
}

