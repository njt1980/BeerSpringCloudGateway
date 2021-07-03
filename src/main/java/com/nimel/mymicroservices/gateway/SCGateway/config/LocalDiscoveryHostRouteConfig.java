package com.nimel.mymicroservices.gateway.SCGateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("localdiscovery")
@Configuration
public class LocalDiscoveryHostRouteConfig {
	
	@Bean
	public RouteLocator localHostRoutes(RouteLocatorBuilder builder) {
		
		return builder.routes()
				.route(r -> r.path("/api/v1/beer*","/api/v1/beer*/*","/api/v1/beer/*").uri("lb://beer-service"))
				.route(r -> r.path("/api/v1/customers/*/*","/api/v1/customers/*/*/*").uri("lb://beerorderservice"))
				.route(r -> r.path("/api/v1/beer/*/*","/api/v1/beer/*/Inventory").uri("lb://inventoryservice"))
				.build();
		
	}
	
	
	
}
