package com.example.shop.test.connector;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import com.example.customer.dto.ArticleDTO;
import com.example.shop.connector.ForeignArticleRestConnectorRequester;

@ExtendWith(MockitoExtension.class)
public class ForeignArticleRestConnectorRequesterTest {

    @Mock
    private ForeignArticleRestConnectorRequester articleRestConnector;

    @Test
    void testGetArticleById() {
        ArticleDTO mockArticle = new ArticleDTO(1L, "Test Article", 10.0);
        when(articleRestConnector.getArticleById(1L)).thenReturn(mockArticle);

        ArticleDTO result = articleRestConnector.getArticleById(1L);

        assertNotNull(result);
        assertEquals("Test Article", result.getName());
    }
}
