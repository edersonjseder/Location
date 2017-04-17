package com.aroundinfo.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.aroundinfo.project.dao.CountryDAO;
import com.aroundinfo.project.model.Country;



@Component
public class CountryService {
	
	// Dependency Injection on CountryDao with Spring
	@Autowired
	private CountryDAO dao;
	
	/**
	 * Method that get the whole list of countries
	 * 
	 * @param name
	 * @return
	 */
	public List<Country> getCountries() {
		
		List<Country> countrysList = dao.getCountryList();
		
		return countrysList;
	}
	
	/**
	 * Method that get a Country object by its name that comes as a parameter from browser
	 * 
	 * @param name
	 * @return
	 */
	public Country getCountryByName(String name) {
		
		Country country = dao.getCountryByName(name);
		
		return country;
	}
	
	/**
	 * Method that gets a Country object by its id that comes as a parameter from browser
	 * 
	 * @param name
	 * @return
	 */
	public Country getCountryById(Integer id) {
		return dao.getCountryById(id);
		
	}	
	
	/**
	 * This method saves a new Country object in DB
	 * 
	 * @param City
	 * @return
	 */
	@Transactional(rollbackFor=Exception.class)
	public boolean saveOrUpdate(Country country) {
		
		dao.saveOrUpdate(country);
		
		return true;
	}

}
