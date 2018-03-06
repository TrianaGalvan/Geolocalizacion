package mx.com.anzen.geolocalizacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import mx.com.anzen.geolocalizacion.service.GeolocationService;

/**
 * 
 * <p>Main class</p>
 * 
 * @author triana
 * @version conversor-geolocalizacion
 * @since conversor-geolocalizacion
 * @category
 */
@SpringBootApplication
public class Application implements CommandLineRunner{
	
	@Autowired
	private GeolocationService geolocationService; 
	
	public static void main(String[] args) {
		//disabled banner, don't want to see the spring logo
        SpringApplication app = new SpringApplication(Application.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
	}

	/* 
	 * @see org.springframework.boot.CommandLineRunner#run(java.lang.String[])
	 */
	@Override
	public void run(String... args) throws Exception {
		geolocationService.readAndInsertRedordsOfExcel();
	}
}
