package crudApp.crudDemo.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import crudApp.crudDemo.entity.User;
import crudApp.crudDemo.repository.UserRepository;
import io.reactivex.Single;

@Service
public class UserDAOImpl implements UserDAO{

	@Autowired
	UserRepository repo;

	@Override
	public Single<Void> deleteAllData() {
		// TODO Auto-generated method stub
		return null;
	}

	/*@Override
	public Single<User> getUserById(String id) {
		// TODO Auto-generated method stub
		return Single.just(repo.findById(id).get());
	}*/
	
	@Override
	public User getUserById(String id) {
		// TODO Auto-generated method stub
		return repo.findById(id).get();
	}

	@Override
	public Single<User> updateUserData(User userDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User addUserData(User userDTO) {

		System.out.println("Inside Add user data");
		//return	Single.just(repo.save(userDTO));
		return	repo.save(userDTO);

	}

	@Override
	public User getUserByName(String name) {
		// TODO Auto-generated method stub
		return repo.findByName(name);
	}



}
