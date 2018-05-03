package GradleProject.GradleDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


@EnableEurekaServer
@SpringBootApplication
public class GradleDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(GradleDemoApplication.class, args);
	}
}
