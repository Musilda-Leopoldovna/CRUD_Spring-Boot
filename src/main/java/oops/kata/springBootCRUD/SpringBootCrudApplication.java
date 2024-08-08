package oops.kata.springBootCRUD;

import oops.kata.springBootCRUD.config.AppConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppConfig.class, args);
	}

}
