package Banking_Application_Account_Creation.accountCreation.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import Banking_Application_Account_Creation.accountCreation.entity.Customer;
import Banking_Application_Account_Creation.accountCreation.service.AccountCreationService;


public class AccountCreationDAO {

	
	@Autowired
	private AccountCreationService acc;
	
	
	
	
	public AccountCreationDAO() {
	}

	

	public int add(Customer customer){
		System.out.println("about to enter insert data");
		return acc.insertData(customer);
		
	}
	
	
}
