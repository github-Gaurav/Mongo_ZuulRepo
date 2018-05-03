package com.example.demo.service;

import com.example.demo.dao.UserDAO;
import com.example.demo.model.User;

import io.reactivex.Observable;

public class UserDataSearch {
	
  public static	Observable<User> getAllData(){
		
		return Observable.fromArray(UserDAO.get().getUserData());
				
		
	}
	
	public static void main(String[] args) {
		
	}

}
