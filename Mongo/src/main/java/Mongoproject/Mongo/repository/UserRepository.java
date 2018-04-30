package Mongoproject.Mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import Mongoproject.Mongo.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{

	public User findByName(String name);
	public User findByCompany(String company);
	

}
