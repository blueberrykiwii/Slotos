package com.example.shop.test.connector;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.testcontainers.containers.RabbitMQContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@Testcontainers
public class ShopMessagingTest {

    @Container
    public static RabbitMQContainer rabbitMQContainer = new RabbitMQContainer("rabbitmq:3.9-management");

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    void testSendMessage() {
        String message = "Test Order";
        rabbitTemplate.convertAndSend("orderQueue", message);

        Object receivedMessage = rabbitTemplate.receiveAndConvert("orderQueue");
        assertEquals(message, receivedMessage);
    }
}
