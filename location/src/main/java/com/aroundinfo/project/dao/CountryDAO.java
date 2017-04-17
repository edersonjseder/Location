package com.aroundinfo.project.dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.aroundinfo.project.model.Country;

@Repository
@SuppressWarnings("unchecked")
public class CountryDAO extends HibernateDAO<Country> {

	public CountryDAO (){
		super(Country.class);
	}
	
	public void insertOrIpdate(Country country) {
		
		super.saveOrUpdate(country);
		
	}
	
	/**
	 * Method to get a country by its id as parameter
	 * 
	 * @param id
	 * @return
	 */
	public Country getCountryById(Integer id) {

		return super.get(id);

	}
	
	/**
	 * Method to get a country object by its name or snippets of its name as parameter
	 * 
	 * @param name
	 * @return
	 */
	public Country getCountryByName(String name) {
		
		Session sess = getSession();
		Transaction tx = getSession().beginTransaction();
		Query query = sess.createQuery("FROM Country where name LIKE CONCAT('%', ? ,'%')");
		query.setString(0, name);
		Country country = (Country) query.uniqueResult();
		tx.commit();
		
		return country;
	}
	
	/**
	 * Method to get a list of countries by its name or snippets of its name as parameter
	 * 
	 * @param name
	 * @return
	 */
	public List<Country> getCountryListByName(String name) {   
		
		Session sess = getSession();
		Transaction tx = getSession().beginTransaction();
		Query query = sess.createQuery("FROM Country where name LIKE CONCAT('%', ? ,'%')");
		query.setString(0, name);
		List<Country> list = query.list();
		tx.commit();
		
	    return list;
	}
	
	/**
	 * Method to get all countries from DB and put them in a list
	 * 
	 * @return
	 */
	public List<Country> getCountryList() {   
		
		Session sess = getSession();
		Transaction tx = getSession().beginTransaction();
		Query query = sess.createQuery("FROM Country");
		List<Country> list = query.list();
		tx.commit();
		
	    return list;
	}


}
