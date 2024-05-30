package com.sbms.config;

import java.time.LocalDateTime;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

	@Bean
	RouteLocator customRouteLocator(RouteLocatorBuilder locatorBuilder) {
		return locatorBuilder.routes()
							.route(p -> p.path("/sbms/accounts/**")
									.filters(f -> f.rewritePath("/sbms/accounts/(?<segment>.*)", "/${segment}")
									.addResponseHeader("X-RESPONSE-TIME", LocalDateTime.now().toString()))
									.uri("lb://ACCOUNTS"))
							.route(p -> p.path("/sbms/cards/**")
									.filters(f -> f.rewritePath("/sbms/cards/(?<segment>.*)", "/${segment}"))
									.uri("lb://CARDS"))
							.route(p -> p.path("/sbms/loans/**")
									.filters(f -> f.rewritePath("/sbms/loans/(?<segment>.*)", "/${segment}"))
									.uri("lb://LOANS"))
									.build();
	}
}
