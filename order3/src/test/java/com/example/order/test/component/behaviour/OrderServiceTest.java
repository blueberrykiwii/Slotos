package com.example.order.test.component.behaviour;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.order.configuration.*;

@SpringBootTest (classes = OrderConfiguration.class) //ich weis nicht ob das richtig ist hier ein Spring Boot Test zu machen

public class OrderServiceTest {

    @Test
    void contextLoads() {
        // Test, ob die Spring-Anwendung richtig startet
    }
}
