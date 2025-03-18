package com.example.shop.configuration; 

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients  // Aktiviert die Verwendung von Feign Clients
public class ShopConfiguration {
    public static void main(String[] args) {
        SpringApplication.run(ShopConfiguration.class, args);
    }
}
