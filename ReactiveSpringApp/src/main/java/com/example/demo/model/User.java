package com.example.demo.model;

public class User {
	
	private String name;
	private String type;
	
	private User(){}
	
	public static User create(String name, String type){
	
		User user = new User();
		user.setName(name);
		user.setType(type);
		return user;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	@Override
	public String toString(){
		
		return "Customer [name=" + this.name + ", type=" + this.type + "]";
	}

}
