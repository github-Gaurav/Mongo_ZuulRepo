package crudApp.crudDemo.DAO;


import crudApp.crudDemo.entity.User;
import io.reactivex.Single;

public interface UserDAO {
	
	public Single<Void> deleteAllData();
	
	//public Single<User> getUserById(String id);
	
	public User getUserByName(String name);
	public User getUserById(String id);
	public Single<User> updateUserData(User userDTO);
	public User addUserData(User userDTO);


}
