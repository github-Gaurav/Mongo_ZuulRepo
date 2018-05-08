package Banking_Application_Account_Creation.accountCreation.resource;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import Banking_Application_Account_Creation.accountCreation.entity.Customer;
import Banking_Application_Account_Creation.accountCreation.factory.ServiceFactory;
import Banking_Application_Account_Creation.accountCreation.repository.CustomerRepository;


@RestController
public class AccountCreationResource {


	@Autowired
	private  CustomerRepository repo;


	public AccountCreationResource(CustomerRepository userRepo) {
		this.repo = userRepo;

	}

	@PostMapping("/create")
	public int createAccount( @RequestBody Customer customer) throws UnsupportedEncodingException, IOException, ParseException{

		//repo.save(customer);
		System.out.println("Data Saved Successfully");
		return (ServiceFactory.getAccountCreationService().processRequest1(customer) );

	}

}
