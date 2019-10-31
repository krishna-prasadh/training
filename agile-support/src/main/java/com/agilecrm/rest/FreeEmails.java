package com.agilecrm.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.agilecrm.DAO.FreeEmailsDAO;
import com.agilecrm.model.Domain;
import com.googlecode.objectify.Key;
import com.googlecode.objectify.ObjectifyService;

@Path("/free-emails")
public class FreeEmails {
	FreeEmailsDAO fed = new FreeEmailsDAO();

	@GET
	public List<Domain> getFreeEmails() {
		System.out.println("in email class");
		ObjectifyService.begin();

		List<Domain> ne = fed.getFreeEmailsDAO();
		return ne;
	}

	@PUT
	public void updateFreeEmails() {
		ObjectifyService.begin();

	}

	@DELETE
	@Path("/{param}")
	public String deleteFreeEmails(@PathParam("param") Long id) {
		System.out.println("id is  " + id);
		ObjectifyService.begin();

		 fed.deleteFreeEmailsDAO(id);
		return "sucessfully deleted "+id;

	}

	@POST
	// @Consumes(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)

	public String createFreeEmails(@FormParam("name") String name) {

		Domain d = new Domain();
		ObjectifyService.begin();

		d.setDomainName(name);
		Key<Domain> key_val = fed.createFreeEmailsDAO(d);
		

		return "i am " + key_val.getId();
	}

}
