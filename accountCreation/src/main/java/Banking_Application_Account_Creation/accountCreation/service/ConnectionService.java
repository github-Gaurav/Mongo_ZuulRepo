package Banking_Application_Account_Creation.accountCreation.service;

import Banking_Application_Account_Creation.accountCreation.DAO.AccountCreationDAO;
import Banking_Application_Account_Creation.accountCreation.entity.Customer;

public class ConnectionService {
	
	
	public int insertCustomerDetails(Customer customer){
		
		
		return new AccountCreationDAO().add(customer);
	}

}
