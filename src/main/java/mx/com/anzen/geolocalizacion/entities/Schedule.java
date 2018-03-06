/*
 * Copyright (c) 2018 Anzen Soluciones S.A. de C.V.
 * Mexico D.F.
 * All rights reserved.
 *
 * THIS SOFTWARE IS  CONFIDENTIAL INFORMATION PROPIETARY OF ANZEN SOLUCIONES.
 * THIS INFORMATION SHOULD NOT BE DISCLOSED AND MAY ONLY BE USED IN ACCORDANCE THE TERMS DETERMINED BY THE COMPANY ITSELF.
 */
package mx.com.anzen.geolocalizacion.entities;

/**
 * <p>TODO [Add comments of the class]</p>
 * 
 * @author triana
 * @version conversor-geolocalizacion
 * @since conversor-geolocalizacion
 * @category
 */
public class Schedule {
	/**
	 * Schedule in which the branch office is opening during the week. 
	 */
	private String SEM; 
	/**
	 * Schedule in which the branch office is opening on saturdays. 
	 */
	private String SAB; 
	/**
	 * Schedule in which the branch office is opening on sundays. 
	 */
	private String DOM;
	/**
	 * @return the sEM
	 */
	public String getSEM() {
		return SEM;
	}
	/**
	 * @param sEM the sEM to set
	 */
	public void setSEM(String sEM) {
		SEM = sEM;
	}
	/**
	 * @return the sAB
	 */
	public String getSAB() {
		return SAB;
	}
	/**
	 * @param sAB the sAB to set
	 */
	public void setSAB(String sAB) {
		SAB = sAB;
	}
	/**
	 * @return the dOM
	 */
	public String getDOM() {
		return DOM;
	}
	/**
	 * @param dOM the dOM to set
	 */
	public void setDOM(String dOM) {
		DOM = dOM;
	} 
	
	
}
