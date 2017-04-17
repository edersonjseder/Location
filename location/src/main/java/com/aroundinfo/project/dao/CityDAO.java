package com.aroundinfo.project.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.aroundinfo.project.model.City;
import com.aroundinfo.project.model.Country;

@Repository
@SuppressWarnings("unchecked")
public class CityDAO extends HibernateDAO<City> {

	public CityDAO (){
		super(City.class);
	}
	
	public void insertOrIpdate(City city) {
		
		super.saveOrUpdate(city);
		
	}	
	
	/**
	 * Method to get a city by its id as parameter
	 * 
	 * @param id
	 * @return
	 */
	public City getCityById(Integer id) {

		return super.get(id);

	}
	
	/**
	 * Method to get a list of cities by its name as parameter
	 * 
	 * @param name
	 * @return
	 */
	public List<City> getCityByName(String name) {
		
		Session sess = getSession();
		Transaction tx = getSession().beginTransaction();
		Query query = sess.createQuery("from City where name = ?");
		query.setString(0, name);
		List<City> list = query.list();
		tx.commit();
		
		return list;
	}
	
	/**
	 *  Method to get a list of cities by its id as parameter
	 * 
	 * @param id
	 * @return
	 */
	public List<City> getCityListById(Integer id) {
		
		Session sess = getSession();
		Transaction tx = getSession().beginTransaction();
		Query query = sess.createQuery("from City where country_id = ?");
		query.setInteger(0, id);
		List<City> list = query.list();
		tx.commit();
		
		return list;
	}
	
	/**
	 * Method to get a list of cities by an Object as parameter, and
	 * from it, retrieve its id to be the value of search
	 * 
	 * @param country
	 * @return
	 */
	public List<City> getCityListById(Country country) {   
		
		Session sess = getSession();
		Transaction tx = getSession().beginTransaction();
		Query query = sess.createQuery("FROM City where country_id = ?");
		query.setInteger(0, country.getId());
		List<City> list = query.list();
		tx.commit();
		
	    return list;
	}
	
	/**
	 * Method to get all cities from DB and put them in a list
	 * 
	 * @return
	 */
	public List<City> getCitysList() {   
	
		Session sess = getSession();
		Transaction tx = getSession().beginTransaction();
		Query query = sess.createQuery("from City");
		List<City> list = query.list();
		tx.commit();
		
	    return list;
	}


}
