package com.valtech.servlets;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

/**
 * Application Lifecycle Listener implementation class TestListener
 *
 */
public class TestListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("Application is Destroyed...");
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("Application is Loaded...");
	}

}
