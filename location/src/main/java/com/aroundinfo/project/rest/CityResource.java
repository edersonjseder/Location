package com.aroundinfo.project.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.aroundinfo.project.model.City;
import com.aroundinfo.project.model.ResponseJSON;
import com.aroundinfo.project.service.CityService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * REST resource service to get cities information
 * 
 * @author ederson
 *
 */
@Path("/cities")
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
@Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
@Component
public class CityResource {

	/**
	 * Dependency Injection of Spring Framework
	 */
	@Autowired
	private CityService service;
	
	/**
	 * Method returns the list of cities to browser via JSON
	 * @return
	 */
	@GET
	public List<City> get(){
		
		List<City> cityList = null;
		
		cityList = service.getCities();

		return cityList;
	}
	
	/**
	 * Method returns the object city by its parameter id
	 * @param id
	 * @return
	 */
	@GET
	@Path("{id}")
	public City get(@PathParam("id") Integer id){
		
		City city = null;
		
		city = service.getCityById(id);
		
	    return city;
	}
	
	
	/**
	 * Method gets a list of cities by country name, as a parameter coming from browser
	 * @param name
	 * @return
	 */
	@GET
	@Path("/city")
	public List<City> getCityByCountryName(@QueryParam("country") String name){
		
		List<City> cityList = null;
		
		cityList = service.getCityByCountryName(name);
		
	    return cityList;
	}
	
	@POST
	public Response post(City city){
		String stringCityJson = "";
		ResponseJSON response;
		
		
		
		service.saveOrUpdate(city);
		response = ResponseJSON.ok("City added successfully");
		stringCityJson = showResponseJSONFormatted(response);
		
	    return Response.status(200).entity(stringCityJson).build();
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
