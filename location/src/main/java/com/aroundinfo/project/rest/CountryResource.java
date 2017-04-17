package com.aroundinfo.project.rest;

import java.util.List;

import javax.annotation.security.PermitAll;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.aroundinfo.project.model.Country;
import com.aroundinfo.project.model.ResponseJSON;
import com.aroundinfo.project.service.CountryService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * REST resource service to control the Country access
 * 
 * @author ederson
 *
 */
@Path("/country")
@PermitAll
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
@Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
@Component
public class CountryResource {

	
	// DI injection with Spring
	@Autowired
	private CountryService service;
	
	/**
	 * This method returns all cities stored in the DB
	 * 
	 *  - http://localhost:8080/location/rest/country
	 * 
	 * @return
	 */
	@GET
	public List<Country> get(){
		
		List<Country> countryList = null;
		
		countryList = service.getCountries();

		return countryList;
	}
	
	/**
	 * This method retrieves one object Country by its id
	 * 
	 * - http://localhost:8080/location/rest/country/2
	 * 
	 * @param id
	 * @return
	 */
	@GET
	@Path("{id}")
	public Country get(@PathParam("id") Integer id){
		Country country = null;
		
		country = service.getCountryById(id);
		
	    return country;
	}
	
	/**
	 * This method saves a new Country object
	 * 
	 * @param country
	 * @return
	 */
	@POST
	public Response post(Country country){
		String stringCountryJson = "";
		ResponseJSON response;
		
		service.saveOrUpdate(country);
		response = ResponseJSON.ok("Country added successfully");
		stringCountryJson = showResponseJSONFormatted(response);
		
	    return Response.status(200).entity(stringCountryJson).build();
	}

	
	/**
	 * This method transform the Object result into JSON String value
	 * 
	 * @param object
	 * @return
	 */
	private String showResponseJSONFormatted(Object object){
		
		// Turn the object into JSON 
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String stringJson = gson.toJson(object);
		
		return stringJson;
	}
	
	

}
