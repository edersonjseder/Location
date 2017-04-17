package com.aroundinfo.project.rest;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.core.Application;

public class JerseyApplication extends Application {
	

	
	/**
	 * This method configures the 'jersey.config.server.provider.packages' property
	 * that indicates to Jersey which packages are the web service classes and scan
	 * the annotations (@Path, @GET, @POST...) on them.
	 * 
	 */
	@Override
	public Map<String, Object> getProperties() {
		
		Map<String, Object> properties = new HashMap<String, Object>();
		
		// Configure the package to scan classes with REST annotations
		properties.put("jersey.config.server.provider.packages", "com.aroundinfo.project.rest");
		
		return properties;
	}

}
