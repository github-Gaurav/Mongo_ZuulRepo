package crudApp.crudDemo.service;

import java.util.List;

import crudApp.crudDemo.entity.User;
import io.reactivex.Single;

public interface UserService {
	
	
	//public Single<User> getById(String id);
	public Single<User> getById(String id);
	public Single<User> getByUserName(String name);
	public Single<List<User>> getAll();
	public Single<User> addUser(User user);

}
