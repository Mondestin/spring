package fr.ecoledev.gestiondecole;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GestiondecoleApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestiondecoleApplication.class, args);
		System.out.println("The application started on port: 8080 ");
	}

}
