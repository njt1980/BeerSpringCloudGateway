package com.nimel.mymicroservices.gateway.SCGateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("google")
@Configuration
public class GoogleConfig {
	
	@Bean
	public RouteLocator googleRouteLocator(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(r -> r.path("/googlesearch4")
						.filters(f -> f.rewritePath("/googlesearch4(?<segment>/?.*)", "/${segment}"))
						.uri("https://google.com"))
				
				.build();
	}

}
