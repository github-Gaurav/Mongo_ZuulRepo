package com.sample.reactive.springreactivesample.dao;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import com.sample.reactive.springreactivesample.exception.CustomException;
import com.sample.reactive.springreactivesample.modal.PersonEntity;
import com.sample.reactive.springreactivesample.repository.PersonRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository("personDAO")
public class PersonDAOImpl implements PersonDAO {

	@Autowired
	private PersonRepository personRepository;

	@Override
	public List<PersonEntity> addPersonData(PersonEntity personEntity) {
		// TODO Auto-generated method stub
		List<PersonEntity> personList = personRepository.findAll().collectList().block();
		PersonEntity newPersonEntity = new PersonEntity();
		Map<String, PersonEntity> personMap = getMap(personList);
		if (null != personEntity && null != personMap) {
			if (!personMap.containsKey(personEntity.getPersonId())) {
				newPersonEntity.setPersonId(personEntity.getPersonId());
				newPersonEntity.setName(personEntity.getName());
				newPersonEntity.setContact(personEntity.getContact());
				newPersonEntity.setAge(personEntity.getAge());
				personList.add(newPersonEntity);
				return personRepository.saveAll(personList).collectList().block();
			}
		}
		return personRepository.findAll().collectList().block();

	}

	@Override
	public Mono<PersonEntity> updatePersonData(PersonEntity personDTO) throws CustomException {
		List<PersonEntity> personList = personRepository.findAll().collectList().block();
		Mono<PersonEntity> monoPersonEntity = null;
		PersonEntity person = null;

		if (null == personDTO)
			throw new CustomException("Request body is null.", HttpStatus.BAD_REQUEST.toString());
		Map<String, PersonEntity> personMap = getMap(personList);
		if (null != personDTO && null != personMap) {
			if (personMap.containsKey(personDTO.getPersonId())) {
				System.out.println("FOUND ENTITY");
				monoPersonEntity = personRepository.findByPersonId(personDTO.getPersonId());
				person = monoPersonEntity.block();
				person.setPersonId(personDTO.getPersonId());
				person.setName(personDTO.getName());
				person.setContact(personDTO.getContact());
				person.setAge(personDTO.getAge());
				monoPersonEntity = personRepository.save(person);
			}
		}

		if (monoPersonEntity == null) {
			throw new CustomException("User not available to update.", HttpStatus.BAD_REQUEST.toString());
		}
		return monoPersonEntity;
	}

	@Override
	public Mono<Void> deleteAllData() {
		return personRepository.deleteAll();
	}

	@Override
	public Flux<PersonEntity> getPersonList() {
		List<PersonEntity> personList = personRepository.findAll().collectList().block();
		Map<String, PersonEntity> personMap = personList.stream()
				.collect(Collectors.toMap(person -> person.getPersonId(), person -> person));
		return personRepository.findAll();
	}
	
	

	public Map<String, PersonEntity> getMap(List<PersonEntity> personList) {
		return personList.stream().collect(Collectors.toMap(person -> person.getPersonId(), person -> person));
	}

	public Long numberOfExistingPerson() {
		return personRepository.count().block();
	}

}
