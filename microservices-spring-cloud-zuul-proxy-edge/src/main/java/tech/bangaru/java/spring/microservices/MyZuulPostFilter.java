package tech.bangaru.java.spring.microservices;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
/**
 * Filter types 
 * 		 "pre" for pre-routing filtering,
	     "route" for routing to an origin,
	     "post" for post-routing filters, 
	     "error" for error handling
 * @author rbangaru
 *
 */
public class MyZuulPostFilter extends ZuulFilter {

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		System.out.println("Within MyZuulPostFilter run() method..\n Here filter post run operations could be run");
		return null;
	}

	@Override
	public String filterType() {
		return "post";
	}

	@Override
	public int filterOrder() {
		return 2;
	}

}
