package tech.bangaru.java.spring.microservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RestTemplateController {

	@Autowired
	private RestTemplate restTemplate;


	@RequestMapping("/execute")
	public String getServiceInfo(){
		return this.restTemplate.getForObject("http://EUREKACLIENT2/getServiceInfo/", String.class);
	}
}
