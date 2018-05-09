package crudApp.crudDemo.service;

import java.util.List;
import crudApp.crudDemo.entity.User;
import rx.Single;

public interface UserService {
	
	
	//public Single<User> getById(String id);
	public User getById(String id);
	public User getByUserName(String name);
	public Single<List<User>> getAll();
	public Single<User> addUser(User user);

}
