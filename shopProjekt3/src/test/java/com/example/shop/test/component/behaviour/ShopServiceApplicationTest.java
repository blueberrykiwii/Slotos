package com.example.shop.test.component.behaviour;

import com.example.shop.configuration.ShopConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = ShopConfiguration.class) // Stellt sicher, dass ShopConfiguration geladen wird
public class ShopServiceApplicationTest { // Korrigierter Name

    @Test
    void contextLoads() {
        // Test, ob die Spring-Anwendung richtig startet
    }
}
