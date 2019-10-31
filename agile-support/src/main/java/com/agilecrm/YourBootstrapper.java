package com.agilecrm;

import javax.servlet.ServletContextEvent;

import javax.servlet.ServletContextListener;

import com.agilecrm.model.Domain;
import com.agilecrm.model.Email;
import com.googlecode.objectify.ObjectifyService;

public class YourBootstrapper implements ServletContextListener {
	public void contextInitialized(ServletContextEvent event) {
		System.out.println("in listner");
		//ObjectifyService.init();
		
		

		
		
		// etc...
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub

	}
}
