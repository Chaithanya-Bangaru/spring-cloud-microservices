package tech.bangaru.java.spring.microservices;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class MicroservicesSpringCloudHystrixCallleeClientApplication {

	
	@RequestMapping("/getIvaansFamilyNames")
	public List<String> getStringList(){
		return Arrays.asList("Raja", "Shobha","Ivaan");
	}
	
	@RequestMapping("/getIvaansFamilyNamesStrings")
	public String getStrings(){
		return String.join(",", Arrays.asList("Raja", "Shobha","Ivaan"));
	}
	public static void main(String[] args) {
		SpringApplication.run(MicroservicesSpringCloudHystrixCallleeClientApplication.class, args);
	}

}

