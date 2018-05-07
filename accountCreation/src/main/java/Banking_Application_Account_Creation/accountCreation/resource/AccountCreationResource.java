package Banking_Application_Account_Creation.accountCreation.resource;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import Banking_Application_Account_Creation.accountCreation.factory.ServiceFactory;


@RestController
public class AccountCreationResource {



	@PostMapping("/create")
	public int createAccount( @RequestBody InputStream stream) throws UnsupportedEncodingException, IOException, ParseException{

		return (ServiceFactory.getAccountCreationService().processRequest(this ,stream) );

	}

}
