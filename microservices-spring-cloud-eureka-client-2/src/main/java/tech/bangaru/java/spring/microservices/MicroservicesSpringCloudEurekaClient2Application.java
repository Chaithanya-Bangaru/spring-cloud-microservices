package tech.bangaru.java.spring.microservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class MicroservicesSpringCloudEurekaClient2Application {

	@Autowired
	private EurekaClient eurekaClient;
	
	/*
	 * From current client 2, we are calling Client 1 just by knowing the Client1's microservice name 
	 * (abstraction of service impl here which is a key feature of microservice)
	 */
	@RequestMapping("/getServiceInfo")
	private String getOtherServiceInfo() {
		InstanceInfo instance = eurekaClient.getNextServerFromEureka("eurekaClient1", false);
		return "I, eurekaClient2 microservice discovered other microservice named "+instance.getAppName() +"'s home page URL at "+instance.getHomePageUrl();
		//return "This message is from the 2nd client microservice";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(MicroservicesSpringCloudEurekaClient2Application.class, args);
	}

}

