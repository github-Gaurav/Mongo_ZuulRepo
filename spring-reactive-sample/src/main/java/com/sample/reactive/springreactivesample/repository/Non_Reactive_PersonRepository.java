package com.sample.reactive.springreactivesample.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.sample.reactive.springreactivesample.modal.PersonEntity;

@Repository
public interface Non_Reactive_PersonRepository extends MongoRepository<PersonEntity, String>{

}
