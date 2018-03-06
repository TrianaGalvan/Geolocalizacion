/*
 * Copyright (c) 2018 Anzen Soluciones S.A. de C.V.
 * Mexico D.F.
 * All rights reserved.
 *
 * THIS SOFTWARE IS  CONFIDENTIAL INFORMATION PROPIETARY OF ANZEN SOLUCIONES.
 * THIS INFORMATION SHOULD NOT BE DISCLOSED AND MAY ONLY BE USED IN ACCORDANCE THE TERMS DETERMINED BY THE COMPANY ITSELF.
 */
package mx.com.anzen.geolocalizacion.entities;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document	;

/**
 * <p>Model that define the structure of the JSON that will be inserted in mongo db.</p>
 * 
 * @author triana
 * @version conversor-geolocalizacion
 * @since conversor-geolocalizacion
 * @category
 */
@Document(collection = "geolocation")
public class Geolocation implements Serializable{
	/* 
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -1416388146483450305L;
	
	/**
	 * The id of the branch
	 */
	@Id
	private Integer id; 
	
	/**
	 * Position where is located the branch office. 
	 */
	private Position position;
	
	/**
	 * Name of the branch office
	 */
	private String name;
	
	/**
	 * Information of the branch office. 
	 */
	private Information information; 
	
	/**
	 * Schedule of the branch office. 
	 */
	private Schedule openingHours; 
	
	
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the position
	 */
	public Position getPosition() {
		return position;
	}
	/**
	 * @param position the position to set
	 */
	public void setPosition(Position position) {
		this.position = position;
	}
	/**
	 * @return the information
	 */
	public Information getInformation() {
		return information;
	}
	/**
	 * @param information the information to set
	 */
	public void setInformation(Information information) {
		this.information = information;
	}
	/**
	 * @return the openingHours
	 */
	public Schedule getOpeningHours() {
		return openingHours;
	}
	/**
	 * @param openingHours the openingHours to set
	 */
	public void setOpeningHours(Schedule openingHours) {
		this.openingHours = openingHours;
	}
}
