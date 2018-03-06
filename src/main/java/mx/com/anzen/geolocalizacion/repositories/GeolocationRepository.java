/*
 * Copyright (c) 2018 Anzen Soluciones S.A. de C.V.
 * Mexico D.F.
 * All rights reserved.
 *
 * THIS SOFTWARE IS  CONFIDENTIAL INFORMATION PROPIETARY OF ANZEN SOLUCIONES.
 * THIS INFORMATION SHOULD NOT BE DISCLOSED AND MAY ONLY BE USED IN ACCORDANCE THE TERMS DETERMINED BY THE COMPANY ITSELF.
 */
package mx.com.anzen.geolocalizacion.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import mx.com.anzen.geolocalizacion.entities.Geolocation;

/**
 * <p>Data layer that manages operations associated with the Geolocation entity with the data base.</p>
 * 
 * @author triana
 * @version conversor-geolocalizacion
 * @since conversor-geolocalizacion
 * @category
 */
public interface GeolocationRepository extends MongoRepository<Geolocation, Integer>{
	
}
