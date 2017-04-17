package com.aroundinfo.project.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="country")
@XmlRootElement
public class Country implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1046035414546407858L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="country_id")
	private Integer id;
	
	private String name;
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

		
}
