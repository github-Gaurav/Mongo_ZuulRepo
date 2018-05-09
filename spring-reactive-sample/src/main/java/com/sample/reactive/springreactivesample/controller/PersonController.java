package com.sample.reactive.springreactivesample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sample.reactive.springreactivesample.modal.PersonEntity;
import com.sample.reactive.springreactivesample.service.PersonService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class PersonController {

	@Autowired
	private PersonService crudService;


	@GetMapping("/getAllPersonData")
	Flux<PersonEntity> list() {
		return crudService.getAllPersonData();
	}

	@PostMapping("/addPersonData")
	public Mono<ResponseEntity> add(@RequestBody PersonEntity entity) {
		return crudService.addPerson(entity);
	}

	@DeleteMapping(path = "/deleteAll", produces = MediaType.APPLICATION_JSON_VALUE)
	public Mono<Void> deleteAllData() {
		return crudService.deleteAllData();
	}

	@PutMapping(path = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
	public Mono<ResponseEntity> update(@RequestBody PersonEntity personDTO) {
		return crudService.updatePersonData(personDTO);
	}

}
