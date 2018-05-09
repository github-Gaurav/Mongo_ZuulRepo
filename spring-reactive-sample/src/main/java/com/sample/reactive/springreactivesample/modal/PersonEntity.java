package com.sample.reactive.springreactivesample.modal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Pojo class to store details for a person.
 * @author ampandey
 *
 */
@Document(collection = "person")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PersonEntity  {
	@Id
	private String personId;
	
	private String contact;

	private String name;
	
	private int age;
	
	
	public PersonEntity(String personId,String name,String contact,int age){
		this.personId=personId;
		this.name=name;
		this.contact=contact;
		this.age=age;
	}
	
	public PersonEntity(){
		this.personId="0";
		this.name="";
		this.contact="";
	}

	public String getPersonId() {
		return personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}


	
	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "PersonEntity [personId=" + personId + ", contact=" + contact + ", name=" + name + ", age=" + age + "]";
	}

}
