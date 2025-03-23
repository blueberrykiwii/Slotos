package com.example.shop.test.connector;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.customer.dto.ArticleDTO;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(SpringExtension.class)
public class ShopServiceIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void testGetArticleById() {
        ResponseEntity<ArticleDTO> response = restTemplate.getForEntity("/shop/articles/1", ArticleDTO.class);
        assertNotNull(response.getBody());
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}
