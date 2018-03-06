/*
 * Copyright (c) 2018 Anzen Soluciones S.A. de C.V.
 * Mexico D.F.
 * All rights reserved.
 *
 * THIS SOFTWARE IS  CONFIDENTIAL INFORMATION PROPIETARY OF ANZEN SOLUCIONES.
 * THIS INFORMATION SHOULD NOT BE DISCLOSED AND MAY ONLY BE USED IN ACCORDANCE THE TERMS DETERMINED BY THE COMPANY ITSELF.
 */
package mx.com.anzen.geolocalizacion.configuration;

import java.net.UnknownHostException;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.MongoClient;

/**
 * <p>Provides the configuration to connect mongo database with spring</p>
 * 
 * @author triana
 * @version conversor-geolocalizacion
 * @since conversor-geolocalizacion
 * @category
 */
@Configuration
@EnableMongoRepositories(basePackages = {"mx.com.anzen.geolocalizacion.repositories"},
						mongoTemplateRef = "mongoDatabaseTemplate")
public class MongoConfiguration {
	
	/**
	 * the mongoDB host for the configuration database
	 */
	@Value("${mongo.userdatabase.host}")
	private String host;
	
	/**
	 * the mongoDB port for the configuration database
	 */
	@Value("${mongo.userdatabase.port}")
	private int port;
	
	/**
	 * the mongoDB configuration database's name
	 */
	@Value("${mongo.userdatabase.databasename}")
	private String databasename;
	
	@Bean
	@Qualifier("mongoDatabaseTemplate")
	public MongoTemplate mongoDatabaseTemplate() throws UnknownHostException{
		return new MongoTemplate(new MongoClient(host,port), databasename);
	}
}
