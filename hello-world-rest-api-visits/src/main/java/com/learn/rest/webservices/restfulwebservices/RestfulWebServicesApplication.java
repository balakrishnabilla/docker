package com.learn.rest.webservices.restfulwebservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestfulWebServicesApplication implements CommandLineRunner {

	private final VisitorRepository visitorRepository;

	@Autowired
	public RestfulWebServicesApplication(VisitorRepository visitorRepository) {
		this.visitorRepository = visitorRepository;
	}
	public static void main(String[] args) {
		SpringApplication.run(RestfulWebServicesApplication.class, args);
	}

	@Override
	public void run(String... strings) {

		//Populating embedded database here

	/*	Visitor visitor = new Visitor();
		visitor.setId(Long.valueOf(1));
		visitor.setVisits(0);
		visitorRepository.save(visitor);*/

	}
}