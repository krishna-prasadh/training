package com.agilecrm.rest;

import java.net.URI;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.client.ClientConfig;

@Path("/restfultest")
public class Restful {

	@GET
	public String restfull() {
		ClientConfig config = new ClientConfig();
		Client client = ClientBuilder.newClient(config);
		WebTarget target = client.target(getBaseURI());
		// Now printing the server code of different media type
		return (target.request().get(String.class));

	}

	private static URI getBaseURI() {
		// here server is running on 4444 port number and project name is restfuljersey
		return UriBuilder.fromUri("https://api.myjson.com/bins/aeka0").build();
	}
}
