package com.sample.reactive.springreactivesample.dao;

import java.util.List;

import com.mongodb.async.client.Observable;
import com.sample.reactive.springreactivesample.exception.CustomException;
import com.sample.reactive.springreactivesample.modal.PersonEntity;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PersonDAO {
	public List<PersonEntity> addPersonData(PersonEntity personDTO);
	
	public Mono<Void> deleteAllData();
	
	public Flux<PersonEntity> getPersonList();
	
	
	public Long numberOfExistingPerson();
	
	public Mono<PersonEntity> updatePersonData(PersonEntity personDTO) throws CustomException;


}
