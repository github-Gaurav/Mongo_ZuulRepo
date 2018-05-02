package com.example.demo.dao;

import com.example.demo.model.User;

public class UserDAO {

	private static UserDAO userDAO = new UserDAO();


	public User[] getUserDetails(){

		User[] user = { User.create("Gaurav", "EnterPrise"),
				User.create("Ankush", "Commercial"),
				User.create("ABXD", "other")
		};

		return user;
	}

	public User[] getUserData(){
		return	getUserDetails();
	}

	public static UserDAO get(){

		return userDAO;
	}

}
