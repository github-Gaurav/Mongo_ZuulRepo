package Banking_Application_Account_Creation.accountCreation.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Banking_Application_Account_Creation.accountCreation.entity.Customer;
import Banking_Application_Account_Creation.accountCreation.factory.ServiceFactory;
import Banking_Application_Account_Creation.accountCreation.repository.CustomerRepository;

@Service
public class AccountCreationService {


	@Autowired
	private CustomerRepository cust;
	
	@Autowired
	private ConnectionService connect;

	ValidationService val = null;
	ConnectionService conn = null;

	/*public int processRequest(AccountCreationResource accountCreationResource, InputStream inputStream) throws UnsupportedEncodingException, IOException, ParseException{

		val = ServiceFactory.getValidationService();
		JSONParser jsonParser = new JSONParser();
		Customer customer = (Customer)jsonParser.parse(
		      new InputStreamReader(inputStream, "UTF-8"));

		int status = val.validateDetails(customer);
		if(status != 200){
			return val.validateDetails(customer);
		}else {

			conn= ServiceFactory.getConnectionService();
		 return	conn.insertCustomerDetails(customer);

		}


	}*/

	public int processRequest1( Customer inputStream) {

		//val = ServiceFactory.getValidationService();
		//JSONParser jsonParser = new JSONParser();
		/*Customer customer = (Customer)jsonParser.parse(
		      new InputStreamReader(inputStream, "UTF-8"));*/

		/*int status = val.validateDetails(inputStream);
		if(status != 200){
			return val.validateDetails(inputStream);
		}else {

			conn= ServiceFactory.getConnectionService();
			return	conn.insertCustomerDetails(inputStream);

		}*/
		conn= ServiceFactory.getConnectionService();
		cust.save(inputStream);
		System.out.println("The data saved successfully");
		return	conn.insertCustomerDetails(inputStream);


	}

	public int insertData(Customer cust1){


		//cust.save(cust1);
		return 200;
	}

}
