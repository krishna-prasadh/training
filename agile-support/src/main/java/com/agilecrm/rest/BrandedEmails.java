package com.agilecrm.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.agilecrm.DAO.BrandedEmailsDAO;
import com.agilecrm.model.Domain;
import com.googlecode.objectify.Key;
import com.googlecode.objectify.ObjectifyService;

@Path("/branded-emails")
public class BrandedEmails {
	BrandedEmailsDAO bed=new BrandedEmailsDAO();
	
	@GET
	public List<Domain> getBrandedEmails(@QueryParam("name") String name) {
		Domain domain=new Domain();
		domain.setDomainName(name);
		ObjectifyService.begin();
		List<Domain> domianList =bed.getBrandedEmailsDAO(domain);
		return domianList;
	}

	@PUT
	public void updateBrandedEmails() {
		ObjectifyService.begin();

	}

	@DELETE
	public void deleteBrandedEmails() {
		ObjectifyService.begin();

	}

	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)

	public String createBrandedEmails(@FormParam("name") String name) {
		Domain domain = new Domain();
		System.out.println("here we go "+name);
		domain.setDomainName(name);
		ObjectifyService.begin();

		Key<Domain> key=bed.createBrandedEmailsDAO(domain);
		System.out.println("key is "+key);
		return "success id is "+key.getId();

	}

}
