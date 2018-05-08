package Banking_Application_Account_Creation.accountCreation.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import Banking_Application_Account_Creation.accountCreation.entity.Customer;



@Repository
public interface CustomerRepository  extends MongoRepository<Customer, String>{

	public Customer findByName(String name);
	//public Customer findByCompany(String company);
	
}
