package com.example.customer.test.component.behaviour;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.customer.configuration.CustomerConfiguration;

@SpringBootTest (classes = CustomerConfiguration.class)
public class CustomerServiceTest {

    @Test
    void contextLoads() {
        // Test, ob die Spring-Anwendung richtig startet
    }
}
