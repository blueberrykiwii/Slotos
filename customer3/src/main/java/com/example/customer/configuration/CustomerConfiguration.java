package com.example.customer.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient  // Aktiviert die Eureka-Integration für Service Discovery
public class CustomerConfiguration {

    public static void main(String[] args) {
        SpringApplication.run(CustomerConfiguration.class, args);
    }
}
