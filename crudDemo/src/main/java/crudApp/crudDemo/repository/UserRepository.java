package crudApp.crudDemo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import crudApp.crudDemo.entity.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{

	public User findByName(String name); 
}
