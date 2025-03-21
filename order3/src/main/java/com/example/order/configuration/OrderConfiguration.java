package com.example.order.configuration;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@Configuration
@EnableDiscoveryClient  // Aktiviert die Eureka-Integration für Service Discovery
@EnableFeignClients     // Aktiviert Feign Client für REST-Kommunikation zwischen Microservices
public class OrderConfiguration {

    public static void main(String[] args) {
        SpringApplication.run(OrderConfiguration.class, args);
    }

    // Queue für Bestellungen
    @Bean
    public Queue orderQueue() {
        return new Queue("orderQueue", true); // "orderQueue" ist der Name der Queue
    }

    // Exchange für RabbitMQ
    @Bean
    public Exchange orderExchange() {
        return new FanoutExchange("orderExchange"); // FanoutExchange sendet an alle angeschlossenen Queues
    }

    // Binding zwischen Queue und Exchange (optional, je nach RabbitMQ Setup)
}

