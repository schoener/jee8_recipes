package de.javaee8recipes.chapter01.recipe0107;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class JeeRecipeServletListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("JEE Recipe servlet context destroyed");
		ServletContextListener.super.contextDestroyed(sce);
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("JEE Recipe servlet context initialized");
		ServletContextListener.super.contextInitialized(sce);
	}

	
	
}
