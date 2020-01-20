package com.crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = { "com.crud.data.repository" })
@EntityScan(basePackages = { "com.crud.data.entity" })
public class Application {

	public static void main(String[] args) {
		
		
	System.out.println("Application Started");
		SpringApplication.run(Application.class, args);

	}

}