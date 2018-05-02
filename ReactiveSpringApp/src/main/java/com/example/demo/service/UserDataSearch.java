package com.example.demo.service;

import com.example.demo.dao.UserDAO;
import com.example.demo.model.User;

import rx.Observable;

public class UserDataSearch {
	
  public static	Observable<User> getAllData(){
		
		return Observable.from(UserDAO.get().getUserData());
				
		
	}
	
	public static void main(String[] args) {
		
	}

}
