package com.sample.reactive.springreactivesample.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.sample.reactive.springreactivesample.modal.PersonEntity;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Repository
public interface PersonRepository extends ReactiveMongoRepository<PersonEntity, String>{
    Mono<PersonEntity> findByPersonId(String personId);
    Flux <PersonEntity> findByName(String name);
    void deleteByPersonId(String personId);
    
   
}
