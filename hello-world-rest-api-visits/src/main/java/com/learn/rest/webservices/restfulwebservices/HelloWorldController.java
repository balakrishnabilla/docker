package com.learn.rest.webservices.restfulwebservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class HelloWorldController {


	private final VisitorRepository visitorRepository;

	@Autowired
	public HelloWorldController(VisitorRepository visitorRepository) {
		this.visitorRepository = visitorRepository;
	}

	@GetMapping(path = "/hello-world")
	public String helloWorld() {
		//incrementAndGetFromRedisCache();
		return "Hello World";
	}

	@GetMapping(path = "/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		incrementAndGetFromRedisCache();
		return new HelloWorldBean("Hello World Bean v5");
	}

	@GetMapping(path = "/hello-world/{name}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
		incrementAndGetFromRedisCache();
		return new HelloWorldBean(String.format("Hello World, %s", name));
	}

	@GetMapping(path = "/hello-world/visits")
	public HelloWorldBean helloWorldVisits() {
		//System.exit(1);//on-failure
		//System.exit(0); //always
		Visitor visitor = incrementAndGetFromRedisCache();
		return new HelloWorldBean(String.format("No of site visits, %s", visitor.getVisits()));
	}

	private Visitor incrementAndGetFromRedisCache() {
		Optional<Visitor> visitorOptional = visitorRepository.findById(Long.valueOf(1));
		Visitor visitor = null;
		if(!visitorOptional.isPresent()) {
			visitor = new Visitor();
			visitor.setId(Long.valueOf(1));

		}else{
			visitor = visitorOptional.get();
		}
		visitor.setVisits(visitor.getVisits()+1);
		visitorRepository.save(visitor);
		return visitor;
	}
}
