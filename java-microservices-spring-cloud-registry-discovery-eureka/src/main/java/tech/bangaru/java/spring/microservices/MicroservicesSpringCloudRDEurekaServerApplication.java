package tech.bangaru.java.spring.microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MicroservicesSpringCloudRDEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicesSpringCloudRDEurekaServerApplication.class, args);
	}
	
	//@Value("#{${serviceUrls}}")
	//private Map<String,String> serviceUrls;

}

