package com.sample.reactive.springreactivesample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.sample.reactive.springreactivesample.repository.PersonRepository;

@SpringBootApplication
@EnableMongoRepositories(basePackageClasses = PersonRepository.class)
public class SpringReactiveSampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringReactiveSampleApplication.class, args);
	}
}
