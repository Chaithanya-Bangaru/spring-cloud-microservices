package tech.bangaru.java.spring.microservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
@RibbonClient(name="ribbon-multiple-clients",value="RibbonLoadBalancingConfig")
public class MicroservicesSpringCloudRibbonLoadBalancerApplication {

	
	@Autowired
	public RestTemplate restTemplate;
	
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}	
	
	@RequestMapping("/startClient")
	public String startClient() {
		//name of the app that clients are running at different ports of 7777,8888,9999
		return this.restTemplate.getForObject("http://ribbon-multiple-clients/execute", String.class);
	}
	public static void main(String[] args) {
		SpringApplication.run(MicroservicesSpringCloudRibbonLoadBalancerApplication.class, args);
	}

}

