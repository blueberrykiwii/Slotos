package com.example.customer.test.component.behaviour;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.customer.CustomerConfiguration;
import com.example.customer.connector.ForeignOrderRestConnectorRequester;

@SpringBootTest (classes = CustomerConfiguration.class)
@MockBean(ForeignOrderRestConnectorRequester.class) // Feign-Client wird gemockt
public class CustomerServiceTest {

	
    @Test
    void contextLoads() {
        // Test, ob die Spring-Anwendung richtig startet
    }
}
