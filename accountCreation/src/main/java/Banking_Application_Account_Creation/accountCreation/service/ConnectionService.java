package Banking_Application_Account_Creation.accountCreation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Banking_Application_Account_Creation.accountCreation.DAO.AccountCreationDAO;
import Banking_Application_Account_Creation.accountCreation.entity.Customer;
import Banking_Application_Account_Creation.accountCreation.repository.CustomerRepository;

@Service
public class ConnectionService {
	
	
	
	public int insertCustomerDetails(Customer customer){
		
	
		
		return new AccountCreationDAO().add(customer);
	}

}
