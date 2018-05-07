package Banking_Application_Account_Creation.accountCreation.service;

import Banking_Application_Account_Creation.accountCreation.DAO.AccountCreationDAO;
import Banking_Application_Account_Creation.accountCreation.entity.Customer;
import Banking_Application_Account_Creation.accountCreation.repository.CustomerRepository;

public class ConnectionService {
	
	
	private static final CustomerRepository CustomerRepository = null;

	public int insertCustomerDetails(Customer customer){
		
		
		return new AccountCreationDAO(CustomerRepository).add(customer);
	}

}
