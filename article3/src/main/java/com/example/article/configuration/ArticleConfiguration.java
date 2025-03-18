//Diese Klasse sollte in deinem Fall der Entry-Point für die Spring Boot Konfiguration des Article Microservices sein.

package com.example.article.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.example.article") // Damit Spring den gesamten Microservice scannen kann
public class ArticleConfiguration {

    public static void main(String[] args) {
        SpringApplication.run(ArticleConfiguration.class, args);
    }
}
