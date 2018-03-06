/*
 * Copyright (c) 2018 Anzen Soluciones S.A. de C.V. Mexico D.F. All rights reserved. THIS
 * SOFTWARE IS CONFIDENTIAL INFORMATION PROPIETARY OF ANZEN SOLUCIONES. THIS INFORMATION
 * SHOULD NOT BE DISCLOSED AND MAY ONLY BE USED IN ACCORDANCE THE TERMS DETERMINED BY THE
 * COMPANY ITSELF.
 */
package mx.com.anzen.geolocalizacion.service;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import mx.com.anzen.geolocalizacion.entities.Address;
import mx.com.anzen.geolocalizacion.entities.Geolocation;
import mx.com.anzen.geolocalizacion.entities.Information;
import mx.com.anzen.geolocalizacion.entities.Position;
import mx.com.anzen.geolocalizacion.entities.Schedule;
import mx.com.anzen.geolocalizacion.enums.CellEnum;
import mx.com.anzen.geolocalizacion.enums.EnumATM;
import mx.com.anzen.geolocalizacion.repositories.GeolocationRepository;
import mx.com.anzen.geolocalizacion.util.FileUtils;

/**
 * <p>Service that coordinate the lecture of the Excel File and access to the data layer in order to insert geolocation records in mongo db</p> 
 * 
 * @author triana 
 * @version conversor-geolocalizacion 
 * @since conversor-geolocalizacion 
 * @category
 */
@Service("geolocationService")
public class GeolocationService {
	
	/**
	 * Data layer to comunicate with mongo db. 
	 */
	@Autowired
	private GeolocationRepository geolocationRepository;
	
	/**
	 * Contains methods associates with manegement of a file. 
	 */
	@Autowired
	@Qualifier("fileUtils")
	private FileUtils fileUtils; 
	
	/**
	 * 
	 * <p>Reads every row of the excel file, transform the data into a model and insert it into the data base.</p>
	 *
	 */
	public void readAndInsertRedordsOfExcel() {
		try {
			//Read Excel file from src/main/resources
			Workbook workbook = fileUtils.readWorkBook();
			
			//Get the first sheet of the workbook
			Sheet sheet = workbook.getSheetAt(0);
			
			//Iterate over the rows of the sheet
			for (int i = 1; i < sheet.getLastRowNum() - 1; i++) {
				DataFormatter formatter = new DataFormatter();
				Row row = sheet.getRow(i);
				if (row != null) {
					Geolocation geolocation = new Geolocation();
					Double id = row.getCell(CellEnum.ID.getColumn()) == null ? 0.0
							: row.getCell(CellEnum.ID.getColumn()).getNumericCellValue();
					geolocation.setId(id.intValue());

					/**
					 * Create information object
					 */
					Information information = new Information();
					
					String atm = row.getCell(CellEnum.ATM.getColumn()) == null ? "" : row.getCell(CellEnum.ATM.getColumn()).getStringCellValue();
					if(atm.equals(EnumATM.HAS_ATM.getValue())) {
						information.setType(EnumATM.JSON_HAS_ATM.getValue());
					}else if(atm.equals(EnumATM.HAS_NOT_ATM.getValue())){
						information.setType(EnumATM.JSON_HAS_NOT_ATM.getValue());
					}else {
						information.setType("");
					}
					

					Address address = new Address();
					address.setCity(row.getCell(CellEnum.CITY.getColumn()) == null ? ""
							: row.getCell(CellEnum.CITY.getColumn()).getStringCellValue());
					address.setColony(row.getCell(CellEnum.COLONY.getColumn()) == null ? ""
							: row.getCell(CellEnum.COLONY.getColumn()).getStringCellValue());
					address.setDelegation(row.getCell(CellEnum.DELEGATION.getColumn()) == null ? ""
							: row.getCell(CellEnum.DELEGATION.getColumn()).getStringCellValue());
					address.setStreet(row.getCell(CellEnum.STREET.getColumn()) == null ? ""
							: row.getCell(CellEnum.STREET.getColumn()).getStringCellValue());
					address.setZipCode(row.getCell(CellEnum.ZIP_COD.getColumn()) == null ? ""
							: formatter.formatCellValue(row.getCell(CellEnum.ZIP_COD.getColumn())));
					address.setPhone_1(row.getCell(CellEnum.TELEPHONE_1.getColumn()) == null ? ""
							: formatter.formatCellValue(row.getCell(CellEnum.TELEPHONE_1.getColumn())));
					address.setPhone_2(row.getCell(CellEnum.TELEPHONE_2.getColumn()) == null ? ""
							: formatter.formatCellValue(row.getCell(CellEnum.TELEPHONE_2.getColumn())));
					information.setAddress(address);
					geolocation.setInformation(information);
					

					/**
					 * Set Name
					 */
					geolocation.setName(row.getCell(CellEnum.NAME.getColumn()) == null ? ""
							: row.getCell(CellEnum.NAME.getColumn()).getStringCellValue());

					/**
					 * Set Position
					 */
					Position position = new Position();

					position.setX(row.getCell(CellEnum.LENGTH.getColumn()) == null ? 0.0
							: Double.parseDouble(formatter.formatCellValue(row.getCell(CellEnum.LENGTH.getColumn()))));
					position.setY(row.getCell(CellEnum.LATITUDE.getColumn()) == null ? 0.0
							: Double.parseDouble(
									formatter.formatCellValue(row.getCell(CellEnum.LATITUDE.getColumn()))));
					geolocation.setPosition(position);

					/**
					 * Set schedule
					 */
					Schedule schedule = new Schedule();
					schedule.setSEM(row.getCell(CellEnum.WEEK_SCHEDULE.getColumn()) == null ? ""
							: row.getCell(CellEnum.WEEK_SCHEDULE.getColumn()).getStringCellValue());
					schedule.setSAB(row.getCell(CellEnum.SATURDAY_SCHEDULE.getColumn()) == null ? ""
							: row.getCell(CellEnum.SATURDAY_SCHEDULE.getColumn()).getStringCellValue());
					schedule.setDOM(row.getCell(CellEnum.SUNDAY_SCHEUDLE.getColumn()) == null ? ""
							: row.getCell(CellEnum.SUNDAY_SCHEUDLE.getColumn()).getStringCellValue());
					geolocation.setOpeningHours(schedule);

					/**
					 * Insert the geolocation object in mongo db
					 */
					geolocationRepository.save(geolocation);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		 } catch (IOException e) {
			 e.printStackTrace();
		 }
	}
}
