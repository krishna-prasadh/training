package com.agilecrm;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import com.agilecrm.model.Domain;
import com.agilecrm.model.Email;
import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.googlecode.objectify.ObjectifyFactory;
import com.googlecode.objectify.ObjectifyFilter;
import com.googlecode.objectify.ObjectifyService;

/**
 * Servlet Filter implementation class ObjectifyWebFilter
 */
@WebFilter("/*")
public class ObjectifyWebFilter extends ObjectifyFilter {

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		System.out.println("in filter");
		//ObjectifyService.init();
		try {
			
			Datastore datastore = DatastoreOptions.newBuilder()
					//.setHost("http://localhost:8484")
					.setProjectId("agile-support").build().getService();
			System.out.println("datastore is " + datastore.getOptions());
			ObjectifyService.init(new ObjectifyFactory(datastore));
		} catch (Exception e) {
			System.out.println("connection failed " + e.getMessage());
		}
	
		 ObjectifyService.register(Email.class);
		ObjectifyService.register(Domain.class);
		System.out.println("class registered");
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("init filter");
	}

}
