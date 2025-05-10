package com.example.API_Gateway.API_Gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


/**
 * The API gateway enables all microservices to be addressed via the same port,
 * although they run on different ports.
 */

@SpringBootApplication
@EnableDiscoveryClient
public class ApiGatewayApplication {
	public static void main(String[] args) {
		SpringApplication.run(
				ApiGatewayApplication.class, args);
	}
}