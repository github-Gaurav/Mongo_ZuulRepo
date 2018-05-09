package crudApp.crudDemo.DAO;


import crudApp.crudDemo.entity.User;
import rx.Single;

public interface UserDAO {
	
	public Single<Void> deleteAllData();
	
	//public Single<User> getUserById(String id);
	
	public User getUserByName(String name);
	public User getUserById(String id);
	public Single<User> updateUserData(User userDTO);
	
	public Single<User> addUserData(User userDTO);


}
