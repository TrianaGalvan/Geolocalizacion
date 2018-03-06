/*
 * Copyright (c) 2018 Anzen Soluciones S.A. de C.V.
 * Mexico D.F.
 * All rights reserved.
 *
 * THIS SOFTWARE IS  CONFIDENTIAL INFORMATION PROPIETARY OF ANZEN SOLUCIONES.
 * THIS INFORMATION SHOULD NOT BE DISCLOSED AND MAY ONLY BE USED IN ACCORDANCE THE TERMS DETERMINED BY THE COMPANY ITSELF.
 */
package mx.com.anzen.geolocalizacion;

import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;

import junit.framework.Assert;
import mx.com.anzen.geolocalizacion.util.FileUtils;

/**
 * <p>TODO [Add comments of the class]</p>
 * 
 * @author triana
 * @version conversor-geolocalizacion
 * @since conversor-geolocalizacion
 * @category
 */
@RunWith(MockitoJUnitRunner.class)
public class FileUtilsTest {
	
	@InjectMocks
	private FileUtils fileUtils; 
	
	@Before
	public void setUp() {
		ReflectionTestUtils.setField(fileUtils, "nombreExcelGeolocalizacion", "Geolocalizacion-cajeros-sucursales.xlsx");
	}
	
	@Test
	public void whenReadFile_thenGenerateWorBook() {
		try {
			Workbook workbook = fileUtils.readWorkBook();
			Assert.assertNotNull(workbook);
		} catch (IOException e) {
		}
	}
	
	
}
