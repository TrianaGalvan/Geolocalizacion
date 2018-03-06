/*
 * Copyright (c) 2018 Anzen Soluciones S.A. de C.V. Mexico D.F. All rights reserved. THIS
 * SOFTWARE IS CONFIDENTIAL INFORMATION PROPIETARY OF ANZEN SOLUCIONES. THIS INFORMATION
 * SHOULD NOT BE DISCLOSED AND MAY ONLY BE USED IN ACCORDANCE THE TERMS DETERMINED BY THE
 * COMPANY ITSELF.
 */
package mx.com.anzen.geolocalizacion.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

/**
 * <p>
 * TODO [Add comments of the class]
 * </p>
 * @author triana @version conversor-geolocalizacion @since
 * conversor-geolocalizacion @category
 */
@Component("fileUtils")
public class FileUtils {

	@Value("${excel.geolocation}")
	private String nombreExcelGeolocalizacion;

	public Workbook readWorkBook() throws FileNotFoundException, IOException {
		ClassPathResource classPath = new ClassPathResource(nombreExcelGeolocalizacion);
		// Get file from resources folder
		FileInputStream file = new FileInputStream(classPath.getFile());
		Workbook workbook = new XSSFWorkbook(file);
		return workbook;
	}
}
