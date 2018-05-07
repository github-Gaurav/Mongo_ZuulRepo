package Banking_Application_Account_Creation.accountCreation.factory;

import Banking_Application_Account_Creation.accountCreation.service.AccountCreationService;
import Banking_Application_Account_Creation.accountCreation.service.ValidationService;

public class ServiceFactory {


	private static ValidationService val =  null;
	private static AccountCreationService accCreation = null;


	public static ValidationService getValidationService(){

		if(val == null){

			val = new ValidationService();
		}

		return val;
	}

	public static AccountCreationService getAccountCreationService(){

		if(accCreation ==  null){
			accCreation = new AccountCreationService();
		}
		return accCreation;
	}

}
