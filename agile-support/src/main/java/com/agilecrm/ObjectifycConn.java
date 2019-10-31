package com.agilecrm;

import com.google.cloud.datastore.DatastoreOptions;
import com.googlecode.objectify.ObjectifyFactory;
import com.googlecode.objectify.ObjectifyFilter;
import com.googlecode.objectify.ObjectifyService;

public class ObjectifycConn  {
	
	public void getLocalConnection() {
		ObjectifyService.init(new ObjectifyFactory(
			    DatastoreOptions.newBuilder()
			        .setHost("http://localhost:8484")
			        .setProjectId("my-project")
			        .build()
			        .getService()
			));
	}
}
