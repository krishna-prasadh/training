package com.agilecrm.rest;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;

import com.agilecrm.DAO.ActivitesDAO;

@Path("/activites")
public class Activites {
	ActivitesDAO act=new ActivitesDAO();
	@GET
	public String getActivites() {
		String data=act.getdataThirdparty();
		return data;

	}

	@PUT
	public String updateActivites() {
		return "activity put";
	}

	@DELETE
	public String deleteActivites() {
		return "activity post";
	}

	@POST
	public String createActivites() {
		return "activity post";
	}
}
