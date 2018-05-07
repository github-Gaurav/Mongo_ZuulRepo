package Banking_Application_Account_Creation.accountCreation.DAO;

import org.springframework.beans.factory.annotation.Autowired;

import Banking_Application_Account_Creation.accountCreation.entity.Customer;
import Banking_Application_Account_Creation.accountCreation.repository.CustomerRepository;


public class AccountCreationDAO {

	@Autowired
	CustomerRepository repo;
	
	public AccountCreationDAO(CustomerRepository repo){
		this.repo = repo;
	}
	
	
	public AccountCreationDAO() {
	}


	public int add(Customer customer){
		System.out.println("About to save user" + customer.getAddress());
		repo.save(customer);
		return 200;
	}
	
}
