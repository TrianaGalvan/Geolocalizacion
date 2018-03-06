/*
 * Copyright (c) 2018 Anzen Soluciones S.A. de C.V.
 * Mexico D.F.
 * All rights reserved.
 *
 * THIS SOFTWARE IS  CONFIDENTIAL INFORMATION PROPIETARY OF ANZEN SOLUCIONES.
 * THIS INFORMATION SHOULD NOT BE DISCLOSED AND MAY ONLY BE USED IN ACCORDANCE THE TERMS DETERMINED BY THE COMPANY ITSELF.
 */
package mx.com.anzen.geolocalizacion.enums;

/**
 * <p>Defines the characters that indicates if a branch office has ATM or NOT in the excel file </p>
 * 
 * @author triana
 * @version conversor-geolocalizacion
 * @since conversor-geolocalizacion
 * @category
 */
public enum EnumATM {
	/**
	 * The branch office has ATM.
	 */
	HAS_ATM("SI"), 
	/**
	 * The branch office has not ATM.
	 */
	HAS_NOT_ATM("X"), 
	/**
	 * String used to indicate in JSON that the branch has ATM. 
	 */
	JSON_HAS_ATM("1"),
	/**
	 * String used to indicate in JSON that the branch has not  ATM. 
	 */
	JSON_HAS_NOT_ATM("2"); 
	
	private final String value;
	
	private EnumATM(String value) {
		this.value = value; 
	}
	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}
	
}
