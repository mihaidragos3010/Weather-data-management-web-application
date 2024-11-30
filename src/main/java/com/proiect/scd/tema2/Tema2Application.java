package com.proiect.scd.tema2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class Tema2Application {

	public static void main(String[] args) {
		SpringApplication.run(Tema2Application.class, args);
	}

}
