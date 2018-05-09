package crudApp.crudDemo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Testing")
public class User {
	
	@Id
	private String mobNo;
	private String name;
	private String age;
	private String address;
	private String dob;
	private String email;
	
	public User(String mobNo, String name, String age, String address, String dob, String email) {
		super();
		this.mobNo = mobNo;
		this.name = name;
		this.age = age;
		this.address = address;
		this.dob = dob;
		this.email = email;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobNo() {
		return mobNo;
	}
	public void setMobNo(String mobNo) {
		this.mobNo = mobNo;
	}

}
