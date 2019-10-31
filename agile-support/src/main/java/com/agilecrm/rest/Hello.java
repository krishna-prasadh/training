package com.agilecrm.rest;

import java.net.http.HttpRequest;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriInfo;

@Path("/project")
public class Hello {

	// This method is called if HTML is requested
	@GET
	@Produces(MediaType.TEXT_HTML)
	@Path("/{param}")
	public String sayHtmlHello(@PathParam("param") String msg,
			@Context HttpRequest request, @Context UriInfo uriInfo) {

		MultivaluedMap<String, String> query = uriInfo.getQueryParameters();

		return "<html> " + "<title>" + "Hello Jersey" + "</title>" + "<body><h1>" + "Hello Jersey " + msg + " " 
				+ " " + request + " params are " + query + "</h1></body>" + "</html> ";
	}

	@DELETE
	public String postmethod() {
		return "i am working";
	}

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayPlainTextHello() {
		return "Hello Jersey Plain";
	}

}