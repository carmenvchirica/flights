package gss.zuul.gateway.flights.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.SimpleRouteLocator;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.stereotype.Component;


public class SimpleRouteFlights extends SimpleRouteLocator {
	
	private static Logger log = LoggerFactory.getLogger(SimpleRouteFlights.class);

	public SimpleRouteFlights(String contextPath, ZuulProperties properties) {
		super(contextPath, properties);
		log.info("Server Context PATH: " + contextPath);
	}
	
}
