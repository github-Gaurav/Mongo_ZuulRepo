package com.sample.reactive.springreactivesample.service;

import org.springframework.http.ResponseEntity;

import com.sample.reactive.springreactivesample.modal.PersonEntity;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PersonService {
	public Mono<ResponseEntity> addPerson(PersonEntity person);

	public Mono<Void> deleteAllData();

	public Flux<PersonEntity> getAllPersonData();

	public Mono<ResponseEntity> updatePersonData(PersonEntity personDTO);
}
