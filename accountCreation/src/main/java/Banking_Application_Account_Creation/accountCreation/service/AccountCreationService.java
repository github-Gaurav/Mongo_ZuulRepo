package Banking_Application_Account_Creation.accountCreation.service;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import Banking_Application_Account_Creation.accountCreation.entity.Customer;
import Banking_Application_Account_Creation.accountCreation.factory.ServiceFactory;
import Banking_Application_Account_Creation.accountCreation.resource.AccountCreationResource;

public class AccountCreationService {
	
	ValidationService val = null;
	ConnectionService conn = null;
	
	public int processRequest(AccountCreationResource accountCreationResource, InputStream inputStream) throws UnsupportedEncodingException, IOException, ParseException{
		
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
		
		
	}
	
public int processRequest1(AccountCreationResource accountCreationResource, Customer inputStream) throws UnsupportedEncodingException, IOException, ParseException{
		
		val = ServiceFactory.getValidationService();
		//JSONParser jsonParser = new JSONParser();
		/*Customer customer = (Customer)jsonParser.parse(
		      new InputStreamReader(inputStream, "UTF-8"));*/
		
		int status = val.validateDetails(inputStream);
		if(status != 200){
			return val.validateDetails(inputStream);
		}else {
			
			conn= ServiceFactory.getConnectionService();
		 return	conn.insertCustomerDetails(inputStream);

		}
		
		
	}

}
