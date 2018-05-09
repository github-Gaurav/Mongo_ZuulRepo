package com.sample.reactive.springreactivesample;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import com.sample.reactive.springreactivesample.controller.PersonController;
import com.sample.reactive.springreactivesample.dao.PersonDAOImpl;
import com.sample.reactive.springreactivesample.modal.PersonEntity;
import com.sample.reactive.springreactivesample.repository.PersonRepository;
import com.sample.reactive.springreactivesample.service.PersonService;
import com.sample.reactive.springreactivesample.service.PersonServiceImpl;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { PersonController.class, PersonServiceImpl.class, PersonDAOImpl.class })
@WebFluxTest
public class SpringReactiveSampleApplicationTests {


	private PersonService personService;

	private PersonDAOImpl personDAO;

	@Autowired
	private WebTestClient webTestClient;

	private PersonController personController;

	@MockBean
	private PersonRepository personRepository;

	@Autowired
	ApplicationContext context;

	@Before
	public void before() {
		List<PersonEntity> personList = new ArrayList();
		Flux<PersonEntity> personFlux = Flux.just(new PersonEntity("24", "Amit", "1234567890", 23),
				new PersonEntity("25", "Sumit", "1234567890", 23), new PersonEntity("26", "Ankur", "1234567890", 23));
		PersonEntity personEntity = new PersonEntity("28", "Mohit", "1234567890", 23);
		Flux<PersonEntity> personFluxAfterInsert = Flux.just(new PersonEntity("24", "Amit", "1234567890", 23),
				new PersonEntity("25", "Sumit", "1234567890", 23), new PersonEntity("26", "Ankur", "1234567890", 23),
				personEntity);
		personList = personFlux.collectList().block();
		personList.add(personEntity);
		personDAO = new PersonDAOImpl();
		personController = new PersonController();
		personService = new PersonServiceImpl();
		ReflectionTestUtils.setField(personService, "personDAO", personDAO);
		ReflectionTestUtils.setField(personController, "crudService", personService);
		ReflectionTestUtils.setField(personDAO, "personRepository", personRepository);
		when(personRepository.findAll()).thenReturn(personFlux);
		when(personRepository.saveAll(Mockito.any(List.class))).thenReturn(personFluxAfterInsert);
		this.webTestClient = WebTestClient.bindToApplicationContext(context).build();

		context.containsBean("personRepository");
	}

	@Test
	public void scenario_add() {
		when(personRepository.count()).thenReturn(Mono.just(new Long(3)));
		PersonEntity personEntity = new PersonEntity("28", "Mohit", "1234567890", 23);
		webTestClient.post().uri("/addPersonData/").accept(MediaType.APPLICATION_JSON)
				.body(BodyInserters.fromObject(personEntity)).exchange().expectStatus().isCreated();
	}

	@Test
	public void scenario_add_negative() {
		when(personRepository.count()).thenReturn(Mono.just(new Long(3)));
		PersonEntity personEntity = new PersonEntity("24", "Mohit", "1234567890", 23);
		webTestClient.post().uri("/addPersonData/").accept(MediaType.APPLICATION_JSON)
				.body(BodyInserters.fromObject(personEntity)).exchange().expectStatus().isBadRequest();
	}

	@Test
	public void scenario_getPersonList() {
		webTestClient.get().uri("/getAllPersonData/").accept(MediaType.APPLICATION_JSON).exchange().expectStatus()
				.isOk();
	}

	@Test
	public void scenario_deletePerson() {
		when(personRepository.deleteAll()).thenReturn(Mono.empty());
		webTestClient.delete().uri("/deleteAll/").accept(MediaType.APPLICATION_JSON).exchange().expectStatus().isOk();
	}

	@Test
	public void scenario_update() {
		PersonEntity personEntity = new PersonEntity("24", "Mohit", "1234567890", 23);
		when(personRepository.findByPersonId("24"))
				.thenReturn(Mono.just(new PersonEntity("24", "Amit", "1234567890", 23)));
		when(personRepository.save(Mockito.any(PersonEntity.class))).thenReturn(Mono.just(personEntity));
		webTestClient.put().uri("/update/").accept(MediaType.APPLICATION_JSON)
				.body(BodyInserters.fromObject(personEntity)).exchange().expectStatus().isOk();
	}

	@Test
	public void scenario_update_negative() {
		PersonEntity personEntity = new PersonEntity("29", "Mohit", "1234567890", 23);
		webTestClient.put().uri("/update/").accept(MediaType.APPLICATION_JSON)
				.body(BodyInserters.fromObject(personEntity)).exchange().expectStatus().isBadRequest();
	}
}
