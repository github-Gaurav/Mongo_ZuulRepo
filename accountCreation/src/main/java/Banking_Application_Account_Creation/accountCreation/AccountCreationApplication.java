package Banking_Application_Account_Creation.accountCreation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AccountCreationApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountCreationApplication.class, args);
	}
}
