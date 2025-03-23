package com.example.shop.configuration; 

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class ShopConfiguration {
    public static void main(String[] args) {
        SpringApplication.run(ShopConfiguration.class, args);
    }
}