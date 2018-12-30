package tech.bangaru.java.spring.microservices;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;


@Controller
@SpringBootApplication
@RestController
//@EnableCircuitBreaker
@EnableHystrix // @EnableCircuitBreaker is included with @EnableHystrix so, commented above annotation
@EnableHystrixDashboard
public class MicroservicesSpringCloudHystrixCircuitBreakerApplication {
	
	@Autowired
	public RestTemplate restTemplate;
	
	
	@Bean
	public RestTemplate createRestTemplate() {
		return this.restTemplate = new RestTemplate();
	}

	/**
	 * Refer Github Hystrix commands doc here 
	 * https://github.com/Netflix/Hystrix/wiki/Configuration
	 * Hystrix Command Properties
		Execution
		execution.isolation.strategy
		execution.isolation.thread.timeoutInMilliseconds
		execution.timeout.enabled
		execution.isolation.thread.interruptOnTimeout
		execution.isolation.thread.interruptOnCancel
		execution.isolation.semaphore.maxConcurrentRequests
		Fallback
		fallback.isolation.semaphore.maxConcurrentRequests
		fallback.enabled
		Circuit Breaker
		circuitBreaker.enabled
		circuitBreaker.requestVolumeThreshold
		circuitBreaker.sleepWindowInMilliseconds
		circuitBreaker.errorThresholdPercentage
		circuitBreaker.forceOpen
		circuitBreaker.forceClosed
		and so forth
	 * @param time
	 * @return
	 * @throws InterruptedException
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/startClient")
	@HystrixCommand(fallbackMethod="hystrixCommandFallback",commandProperties= {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "500")
	})
	public List<String> getRestTemplate(@RequestParam long time) throws InterruptedException {
		Thread.sleep(time);
		return  this.restTemplate.getForObject("http://localhost:6763/getIvaansFamilyNames", List.class);
	}
	
	public List<String> hystrixCommandFallback(@RequestParam long time) {
		return  Arrays.asList("Bunni","Naani","Chinni");
	}

	public static void main(String[] args) {
		SpringApplication.run(MicroservicesSpringCloudHystrixCircuitBreakerApplication.class, args);
	}
}

