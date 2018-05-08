package Banking_Application_Account_Creation.accountCreation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import Banking_Application_Account_Creation.accountCreation.repository.CustomerRepository;

@SpringBootApplication
@EnableEurekaClient
public class AccountCreationApplication {
	
	

	public static void main(String[] args) {
		SpringApplication.run(AccountCreationApplication.class, args);
	}
	
	
	
}
