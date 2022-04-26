package gss.zuul.gateway.flights.filters;

import org.springframework.cloud.commons.httpclient.ApacheHttpClientConnectionManagerFactory;
import org.springframework.cloud.commons.httpclient.ApacheHttpClientFactory;
import org.springframework.cloud.netflix.zuul.filters.ProxyRequestHelper;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.cloud.netflix.zuul.filters.route.SimpleHostRoutingFilter;
import org.springframework.stereotype.Component;


public class SimpleHost extends SimpleHostRoutingFilter{

	public SimpleHost(ProxyRequestHelper helper, ZuulProperties properties,
			ApacheHttpClientConnectionManagerFactory connectionManagerFactory,
			ApacheHttpClientFactory httpClientFactory) {
		super(helper, properties, connectionManagerFactory, httpClientFactory);
	}

}
