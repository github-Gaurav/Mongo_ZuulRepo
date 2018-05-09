package com.sample.reactive.springreactivesample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sample.reactive.springreactivesample.dao.PersonDAO;
import com.sample.reactive.springreactivesample.exception.CustomException;
import com.sample.reactive.springreactivesample.modal.PersonEntity;
import com.sample.reactive.springreactivesample.modal.Response;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service("CrudService")
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonDAO personDAO;

	@SuppressWarnings("unchecked")
	@Override
	public Mono<ResponseEntity> addPerson(PersonEntity person) {
		Response resp = null;
		long numberOfExistingPerson = sizeOfPersonMap();
		if (person == null) {
			resp = wrapInResponse(
					new CustomException("Please Pass the data of person to add", HttpStatus.BAD_REQUEST.toString()));
			return Mono.just(new ResponseEntity(resp, HttpStatus.BAD_REQUEST));
		}
		List<PersonEntity> personData = personDAO.addPersonData(person);
		if (numberOfExistingPerson == personData.size()) {
			resp = wrapInResponse(
					new CustomException("Data Already Exists for this person", HttpStatus.BAD_REQUEST.toString()));
			return Mono.just(new ResponseEntity(resp, HttpStatus.BAD_REQUEST));
		}
		return Mono.just(new ResponseEntity(new Response(HttpStatus.CREATED.toString(),
				"Person Data Added to the Database", personDAO.addPersonData(person)), HttpStatus.CREATED));
	}

	@Override
	public Mono<Void> deleteAllData() {
		return personDAO.deleteAllData();
	}

	@Override
	public Flux<PersonEntity> getAllPersonData() {
		return personDAO.getPersonList();
	}

	private long sizeOfPersonMap() {
		long numberOfExistingPerson = personDAO.numberOfExistingPerson();
		return numberOfExistingPerson;
	}

	public Response wrapInResponse(CustomException ce) {
		return new Response(ce.getStatusCode(), ce.getExceptionMessage());
	}

	@Override
	public Mono<ResponseEntity> updatePersonData(PersonEntity personDTO) {
		PersonEntity entity;
		try {
			entity = personDAO.updatePersonData(personDTO).block();
		} catch (CustomException ce) {
			Response resp = wrapInResponse(ce);
			return Mono.just(new ResponseEntity(resp, HttpStatus.BAD_REQUEST));
		}
		return Mono.just(new ResponseEntity(
				new Response(HttpStatus.OK.toString(), "Person Data updated to the Database", entity), HttpStatus.OK));

	}
}
