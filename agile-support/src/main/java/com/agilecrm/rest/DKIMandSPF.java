package com.agilecrm.rest;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;

import com.agilecrm.DAO.DKIMandSPFDAO;
import com.agilecrm.model.Email;
import com.googlecode.objectify.Key;
import com.googlecode.objectify.ObjectifyService;

@Path("/dkim-spf")
public class DKIMandSPF {

	DKIMandSPFDAO ds = new DKIMandSPFDAO();

	@GET
	public List<Email> getDKIMandSPF() {
		ObjectifyService.begin();
		List<Email> list = ds.getDKIMandSPFDAO();

		return list;
	}

	@PUT
	public Key<Email> updateDKIMandSPF(@FormParam("email") String email, @FormParam("name") String name,
			@FormParam("id") Long id) {
		Email e = new Email();

		e.setDomainName(name);
		e.setEmail(email);
		e.setId(id);
		ObjectifyService.begin();
		Key<Email> key = ds.updateDKIMandSPFDAO(e);
		return key;
	}

	@DELETE
	public String deleteDKIMandSPF() {
		ObjectifyService.begin();

		return "dkim&spf Delete";
	}

	@POST
	public String createDKIMandSPF(@FormParam("email") String email, @FormParam("name") String name) {
		Email e = new Email();
		e.setEmail(email);
		e.setDomainName(name);
		ObjectifyService.begin();

		Key<Email> key = ds.createDKIMandSPFDAO(e);
		return "Success adding " + key.getId();
	}

}
