package com.example.article.test.component.behaviour;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.article.ArticleConfiguration;

@SpringBootTest(classes = ArticleConfiguration.class) // Verweis auf deine Konfigurationsklasse
public class ArticleServiceTest {

    @Test
    void contextLoads() {
        // Test, ob die Spring-Anwendung richtig startet
    }
}
