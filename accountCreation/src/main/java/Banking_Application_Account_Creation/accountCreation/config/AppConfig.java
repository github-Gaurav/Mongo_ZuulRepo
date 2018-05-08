package Banking_Application_Account_Creation.accountCreation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import Banking_Application_Account_Creation.accountCreation.service.AccountCreationService;

@Configuration
//@EnableMongoRepositories({ "Banking_Application_Account_Creation.accountCreation.repository" })
public class AppConfig {
	
	
	@Bean
	public AccountCreationService getAccountCreation(){
		
		return new AccountCreationService();
	}
	
}
