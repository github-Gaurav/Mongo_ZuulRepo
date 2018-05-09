package crudApp.crudDemo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import crudApp.crudDemo.DAO.UserDAO;
import crudApp.crudDemo.entity.User;
import rx.Single;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private	UserDAO userDAO;

	
	@Override
	public Single<User> getById(String id){

		
		return Single.just(id).map(u-> userDAO.getUserById(u)).flatMap(func);
		//return userDAO.getUserById(id);
	}

	@Override
	public User getByUserName(String name){

		return userDAO.getUserByName(name);
	}

	@Override
	public Single<List<User>> getAll(){

		return null;

	}

	@Override
	public Single<User>addUser(User user){

		System.out.println("Inside Add User Service");
		return userDAO.addUserData(user);

	}

}
