package tech.bangaru.java.spring.microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;
/**
 * 
 * @author rbangaru
 * Zuul Edge service proxies the microservice and abstracts the internal details of the client
 * microservice. It acts as a front controller, proxies and routes to the appropriate microservices
 */
@SpringBootApplication
@RestController
@EnableZuulProxy
public class MicroservicesSpringCloudZuulProxyProxyEdgeApplication {
	
	
	@Bean
	public MyZuulPreFilter filter() {
		return new MyZuulPreFilter();
	}
	
	@Bean
	public MyZuulPostFilter filter2() {
		return new MyZuulPostFilter();
	}
	@Bean
	public MyZuulErrorFilter filter3() {
		return new MyZuulErrorFilter();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(MicroservicesSpringCloudZuulProxyProxyEdgeApplication.class, args);
	}

}

