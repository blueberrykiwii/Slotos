package com.example.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = "com.example.order")
@EnableDiscoveryClient  // Eureka-Service Discovery aktivieren
@EnableFeignClients     // Feign Clients für REST-Kommunikation aktivieren
public class OrderApplication {  // 🔥 KORREKTER NAME (anstatt OrderConfiguration)
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }
}

