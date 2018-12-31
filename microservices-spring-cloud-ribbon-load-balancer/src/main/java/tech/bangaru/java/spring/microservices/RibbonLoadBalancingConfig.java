package tech.bangaru.java.spring.microservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AvailabilityFilteringRule;
import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.PingUrl;

public class RibbonLoadBalancingConfig {
	
	@Autowired
	public IClientConfig ribbonClientConfig;
	
	
	/**
	 * Ribbon Load balancer pings the clients to check if they are live and running fine 
	 * before routing the user's request to that particular client microservice
	 */
	@Bean 
	public IPing ping (IClientConfig config){
		return new PingUrl();
	}
	
	/**
	 * One of different type of rules that Load balancer uses
	 */
	@Bean 
	public IRule rule (IClientConfig config){
		return new AvailabilityFilteringRule();
	}

}
