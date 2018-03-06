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
 * <p>Associate the name and the number of the column on the excel file.</p>
 * 
 * @author triana
 * @version conversor-geolocalizacion
 * @since conversor-geolocalizacion
 * @category
 */
public enum CellEnum {
	/**
	 * ID of the branch office.
	 */
	ID(0), 
	/**
	 * Name of the branch office.
	 */
	NAME(1),
	/**
	 * Name of the street where is located the branch. 
	 */
	STREET(2),
	/**
	 * Name of the colony where is located the branch.
	 */
	COLONY(3),
	/**
	 * Zip code of the branch office 
	 */
	ZIP_COD(4), 
	/**
	 * Delegation where is located the branch office. 
	 */
	DELEGATION(5),
	/**
	 * City where is located the branch office
	 */
	CITY(6), 
	/**
	 * Length 
	 */
	LENGTH(7),
	/**
	 * Latitude 
	 */
	LATITUDE(8),
	/**
	 * Define if the branch has ATM or not. 
	 */
	ATM(9), 
	/**
	 * Schedule of the branch during the week. 
	 */
	WEEK_SCHEDULE(10), 
	/**
	 * Schedule of the branch on Saturdays. 
	 */
	SATURDAY_SCHEDULE(11), 
	/**
	 * Schedule of the branch on Sundays
	 */
	SUNDAY_SCHEUDLE(12), 
	/**
	 * Telephone 1
	 */
	TELEPHONE_1(13),
	/**
	 * Telephone 2 
	 */
	TELEPHONE_2(14);
	
	/**
	 * Value that take the Enum. 
	 */
	private final int column; 
	
	/**
	 * Constructor
	 * 
	 * @param value
	 */
	private CellEnum(int value) {
		this.column = value; 
	}

	/**
	 * @return the column
	 */
	public int getColumn() {
		return column;
	}
	
	
}
