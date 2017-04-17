package com.aroundinfo.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.aroundinfo.project.dao.CityDAO;
import com.aroundinfo.project.dao.CountryDAO;
import com.aroundinfo.project.model.City;
import com.aroundinfo.project.model.Country;



@Component
public class CityService {
	
	// Dependency Injection on CityDao with Spring
	@Autowired
	private CityDAO cityDao;
	
	// Dependency Injection on CountryDao with Spring
	@Autowired
	private CountryDAO countryDao;
	
	/**
	 * Method that get the whole list of cities
	 * 
	 * @param name
	 * @return
	 */
	public List<City> getCities() {
		
		List<City> CitysList = cityDao.getCitysList();
		
		return CitysList;
	}
	
	/**
	 * Method that get a list of cities by its id that comes as a parameter from browser
	 * 
	 * @param name
	 * @return
	 */
	public List<City> getCityListById(Integer id) {
		
		List<City> CitysList = cityDao.getCityListById(id);
		
		return CitysList;
	}
	
	
	/**
	 * Method that get a list of cities by country name, coming as a parameter from browser
	 * 
	 * @param name
	 * @return
	 */
	public List<City> getCityByCountryName(String name){
		
		List<City> cityList = null;
		
		Country country = null;
		
		country = countryDao.getCountryByName(name);
		
		if(country == null){
			
			cityList = cityDao.getCitysList();
			
		} else {
			
			cityList = cityDao.getCityListById(country.getId());
			
		}
		
	    return cityList;
	}
	
	/**
	 * Method that get a city by its id, coming as a parameter from browser
	 * 
	 * @param id
	 * @return
	 */
	public City getCityById(Integer id) {
		return cityDao.getCityById(id);
		
	}	
	
	/**
	 * This method saves a new City object in DB
	 * 
	 * @param city
	 * @return
	 */
	@Transactional(rollbackFor=Exception.class)
	public boolean saveOrUpdate(City city) {
		
		cityDao.saveOrUpdate(city);
		
		return true;
	}

}
