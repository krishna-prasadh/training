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

import com.agilecrm.DAO.DatasyncDAO;
import com.agilecrm.model.Domain;
import com.googlecode.objectify.Key;
import com.googlecode.objectify.ObjectifyService;

@Path("/datasync")
public class Datasync {
	
	DatasyncDAO dsdao=new DatasyncDAO();
	
	@GET
	public List<Domain> getDatasync(@QueryParam("name") String name) {
		Domain domain=new Domain();
		domain.setDomainName(name);
		ObjectifyService.begin();
		List<Domain> domainlist=dsdao.getDatasyncDAO();
		return domainlist;
	}

	@PUT
	public void updateDatasync() {
		ObjectifyService.begin();

	}

	@DELETE
	public void deleteDatasync() {
		ObjectifyService.begin();

	}

	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	
	public String createDatasync(@FormParam("name") String name) {
		Domain domain=new Domain();
		domain.setDomainName(name);
		ObjectifyService.begin();

		Key<Domain> key=dsdao.createDatasyncDAO(domain);
		
		return "Success "+key.getId();
	}

}
