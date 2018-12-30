package tech.bangaru.java.spring.microservices;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;

@Configuration
public class HystrixServletDefinitions {

	@SuppressWarnings("rawtypes")
	@Bean(name = "hystrixRegistrationBean")
	public ServletRegistrationBean servletRegistrationBean() {
		@SuppressWarnings({ "rawtypes", "unchecked" })
		ServletRegistrationBean registration = new ServletRegistrationBean(new HystrixMetricsStreamServlet(),
				"/hystrix.stream");
		registration.setName("hystrixServlet");
		registration.setLoadOnStartup(1);
		return registration;
	}
}