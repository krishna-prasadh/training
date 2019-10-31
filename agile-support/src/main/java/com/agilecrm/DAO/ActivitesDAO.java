package com.agilecrm.DAO;

import com.agilecrm.rest.Restful;

public class ActivitesDAO {
	
	public String getdataThirdparty() {
		Restful rest=new Restful();
		String str=rest.restfull();
		return str;
	}

}
