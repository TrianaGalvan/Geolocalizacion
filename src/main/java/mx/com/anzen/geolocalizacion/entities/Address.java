/*
 * Copyright (c) 2018 Anzen Soluciones S.A. de C.V. Mexico D.F. All rights reserved. THIS
 * SOFTWARE IS CONFIDENTIAL INFORMATION PROPIETARY OF ANZEN SOLUCIONES. THIS INFORMATION
 * SHOULD NOT BE DISCLOSED AND MAY ONLY BE USED IN ACCORDANCE THE TERMS DETERMINED BY THE
 * COMPANY ITSELF.
 */
package mx.com.anzen.geolocalizacion.entities;

import java.io.Serializable;

/**
 * <p>
 * Defines the complete address of the branch office
 * </p>
 * @author triana 
 * @version conversor-geolocalizacion 
 * @since conversor-geolocalizacion @category
 */
public class Address implements Serializable {
	/*
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -3728242650882631104L;

	/**
	 * Street where is located the branch office. 
	 */
	private String street;
	
	/**
	 * Colony where is located the branch office. 
	 */
	private String colony;
	
	/**
	 * Zip code of the branch office. 
	 */
	private String zipCode;

	/**
	 * Delegation where is located the branch office.
	 */
	private String delegation;

	/**
	 * City where is located the branch office. 
	 */
	private String city;
	
	/**
	 * Phone 1 of the branch
	 */
	private String phone_1;
	
	/**
	 * Phone 2 of the branch
	 */
	private String phone_2; 

	/**
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * @param street the street to set
	 */
	public void setStreet(String street) {
		this.street = street;
	}

	/**
	 * @return the colony
	 */
	public String getColony() {
		return colony;
	}

	/**
	 * @param colony the colony to set
	 */
	public void setColony(String colony) {
		this.colony = colony;
	}

	/**
	 * @return the zipCode
	 */
	public String getZipCode() {
		return zipCode;
	}

	/**
	 * @param zipCode the zipCode to set
	 */
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	/**
	 * @return the delegation
	 */
	public String getDelegation() {
		return delegation;
	}

	/**
	 * @param delegation the delegation to set
	 */
	public void setDelegation(String delegation) {
		this.delegation = delegation;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the phone_1
	 */
	public String getPhone_1() {
		return phone_1;
	}

	/**
	 * @param phone_1 the phone_1 to set
	 */
	public void setPhone_1(String phone_1) {
		this.phone_1 = phone_1;
	}

	/**
	 * @return the phone_2
	 */
	public String getPhone_2() {
		return phone_2;
	}

	/**
	 * @param phone_2 the phone_2 to set
	 */
	public void setPhone_2(String phone_2) {
		this.phone_2 = phone_2;
	}
}
