package tech.bangaru.java.spring.microservices;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class MicroservicesSpringCloudRibbonMultipleClientsApplication {


	@Value(value = "${server.port}")
	public String port;
	
	@RequestMapping("/execute")
	public String greetFromClient() {
		return "Hello from service of port:"+this.port;
	}
	
	@RequestMapping("/")
	public String status() {
		return "Service UP and running!";
	}
	public static void main(String[] args) {
		SpringApplication.run(MicroservicesSpringCloudRibbonMultipleClientsApplication.class, args);
	}

}

