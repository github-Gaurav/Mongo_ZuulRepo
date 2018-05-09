package crudApp.crudDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;



//@SpringBootApplication(scanBasePackages={"crudApp.crudDemo.repository"})
@SpringBootApplication
@ComponentScan
public class CrudDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudDemoApplication.class, args);
	}
}
